package com.lsl.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

import com.lsl.model.Dep;
import com.lsl.model.Emp;
import com.lsl.model.Role;
import com.lsl.query.EmpQuery;
import com.lsl.service.DepService;
import com.lsl.service.EmpService;
import com.lsl.service.RoleService;
import com.lsl.utils.MD5Utils;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class EmpAction extends BaseAction {
	/**
	 * 接收用户的Code
	 */
	private String rCode;
	
	/**
	 * 神仙Bug，myEclipse生成的rCode的get和set是有问题的，这里注意命名的规范，在一个小写字母后面
	 * 不能紧跟一个大写字母。
	 * @return
	 */
	public String getRCode() {
		return rCode;
	}
	
	public void setRCode(String rCode) {
		this.rCode = rCode;
	}
	private String roleIds;
	
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public RoleService roleService;
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	private String result = "yes";

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private Emp emp;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	private EmpService empService;

	public EmpService getEmpService() {
		return empService;
	}

	/*
	 * 这里必须要提供set方法才能实现注入
	 */
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	private DepService depService;

	public DepService getDepService() {
		return depService;
	}

	public void setDepService(DepService depService) {
		this.depService = depService;
	}

	/**
	 * 一定要先实例化，防止空指针异常
	 */
	private EmpQuery query = new EmpQuery();

	public void setQuery(EmpQuery query) {
		this.query = query;
	}

	/*
	 * 这里不提供get方法会导致有些值取不到
	 */
	public EmpQuery getQuery() {
		return query;
	}

	public String emp_list() {
		// 展示部门列表
		List<Dep> list = depService.list();
		ActionContext.getContext().put("dList", list);
		if (query.getPageNum() == null || query.getPageNum() <= 0) {
			query.setPageNum(1);
		}
		// 展示员工列表
		Page page = empService.queryObjByCondition(query, super.exclude);
		ActionContext.getContext().put("page", page);
		return super.SUCCESS;
	}

	public String emp_listpop() {
		List<Role> stateRoles = empService.getStateRoles(emp.getEmpId());
		ActionContext.getContext().put("roles", stateRoles);
		return super.SUCCESS;
	}

	public String emp_input() {
		// 展示部门列表
		List<Dep> list = depService.list();
		ActionContext.getContext().put("dList", list);
		return super.SUCCESS;
	}

	public String emp_changePwd() {
		return super.SUCCESS;
	}

	public String emp_delete() {
		empService.deleteObjById(emp.getEmpId());
		return LIST;
	}

	public void ajax_emp_validateUsername() throws IOException {
		Emp emp2 = empService.getEmpByUsername(emp.getUsername());
		if (emp2 != null) {
			result = "no";
		}
		response.getWriter().print(result);
	}

	public void ajax_emp_add() throws IOException {
		// 使用MD5加密
		emp.setPassword(MD5Utils.md5(emp.getPassword()));
		empService.save(emp);
		// 成功返回success
		result = "success";
		response.getWriter().print(result);
	}

	public void ajax_emp_grantRoles() throws IOException {
		empService.updateEmpRole(emp.getEmpId(), roleIds);
		response.getWriter().print(result);
		System.out.println(result);
	}

	public void ajax_emp_update() throws IOException {
		result = "success";
		/**
		Emp tempt = empService.getObjById(emp.getEmpId());
		emp.setPassword(tempt.getPassword());
		empService.update(emp);
		*在这里tempt是持久化对象，如果将emp做更新的话，会将emp也转为持久化对象，而两个的oid一致便会引起
		*冲突 
		*/
		empService.updateEmp(emp);
		response.getWriter().print(result);
	}

	public String emp_update() throws IOException {
		//用emp接收放入值栈之中方便回显
		emp = empService.getObjById(emp.getEmpId());
		// 展示部门列表
		List<Dep> list = depService.list();
		ActionContext.getContext().put("dList", list);
		return super.SUCCESS;
	}
	
	/**
	 *验证validate 
	 */
	public void validateEmp_login(){
		System.out.println("进入验证方法");
		String rrCode = (String) session.getAttribute("rCode");
		if(StringUtils.isNotBlank(rCode)){
			if(StringUtils.equalsIgnoreCase(rrCode, rCode)){
				//验证码通过,验证用户名
				if(StringUtils.isNotBlank(emp.getUsername())){
					//获得emp的持久化对象
					Emp emp = empService.getEmpByUsername(this.emp.getUsername());
					if(emp!=null){
						//用户名存在，检测密码
						if(StringUtils.isNotBlank(this.emp.getPassword())){
							this.emp.setPassword(MD5Utils.md5(this.emp.getPassword()));
							String password = emp.getPassword();
							if(password.equals(this.emp.getPassword())){
								ActionContext.getContext().getSession().put("user", emp);
							}else{
							addFieldError("tip","密码错误");
							}
						}else{
							addFieldError("tip", "密码不能为空!");
						}
					}else{
						addFieldError("tip","该用户名不存在!");
					}
				}else{
					addFieldError("tip","用户名不能为空！");
				}
			}else{
				addFieldError("tip", "验证码输入错误!");
			} 
		}else{
				addFieldError("tip","验证码不能为空!");
		}
		
	}
	
	/**
	 * 用于正式登录
	 * @return
	 */
	public String emp_login(){
		return MAIN;
	}
	
	/**
	 * 用于进入登录页面
	 * @return
	 */
	public String erp_toLogin(){
		return SUCCESS;
	}
	
	/**
	 * 生成验证码的图片
	 * @throws Exception
	 */
	public void ajax_emp_getImage() throws Exception{
	        BufferedImage img = new BufferedImage(68, 22,  
	  
	        BufferedImage.TYPE_INT_RGB);  
	  
	        // 得到该图片的绘图对象    
	  
	        Graphics g = img.getGraphics();  
	  
	        Random r = new Random();  
	  
	        Color c = new Color(200, 150, 255);  
	  
	        g.setColor(c);  
	  
	        // 填充整个图片的颜色    
	  
	        g.fillRect(0, 0, 68, 22);  
	  
	        // 向图片中输出数字和字母    
	  
	        StringBuffer sb = new StringBuffer();  
	        
	  
	        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
	  
	        int index, len = ch.length;  
	  
	        for (int i = 0; i < 4; i++) {  
	  
	            index = r.nextInt(len);  
	  
	            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt  
	  
	            (255)));  
	  
	            g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));  
	            // 输出的  字体和大小                      
	  
	            g.drawString("" + ch[index], (i * 15) + 3, 18);  
	            //写什么数字，在图片 的什么位置画    
	  
	            sb.append(ch[index]);  
	  
	        }  
	        //把验证码的值放入session中
	        request.getSession().setAttribute("rCode", sb.toString());  
	        //把验证码的图片写回浏览器
	        ImageIO.write(img, "JPG", response.getOutputStream());  
	}
}
