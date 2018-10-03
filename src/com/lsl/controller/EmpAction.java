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
	 * �����û���Code
	 */
	private String rCode;
	
	/**
	 * ����Bug��myEclipse���ɵ�rCode��get��set��������ģ�����ע�������Ĺ淶����һ��Сд��ĸ����
	 * ���ܽ���һ����д��ĸ��
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
	 * �������Ҫ�ṩset��������ʵ��ע��
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
	 * һ��Ҫ��ʵ��������ֹ��ָ���쳣
	 */
	private EmpQuery query = new EmpQuery();

	public void setQuery(EmpQuery query) {
		this.query = query;
	}

	/*
	 * ���ﲻ�ṩget�����ᵼ����Щֵȡ����
	 */
	public EmpQuery getQuery() {
		return query;
	}

	public String emp_list() {
		// չʾ�����б�
		List<Dep> list = depService.list();
		ActionContext.getContext().put("dList", list);
		if (query.getPageNum() == null || query.getPageNum() <= 0) {
			query.setPageNum(1);
		}
		// չʾԱ���б�
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
		// չʾ�����б�
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
		// ʹ��MD5����
		emp.setPassword(MD5Utils.md5(emp.getPassword()));
		empService.save(emp);
		// �ɹ�����success
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
		*������tempt�ǳ־û����������emp�����µĻ����ὫempҲתΪ�־û����󣬶�������oidһ�±������
		*��ͻ 
		*/
		empService.updateEmp(emp);
		response.getWriter().print(result);
	}

	public String emp_update() throws IOException {
		//��emp���շ���ֵջ֮�з������
		emp = empService.getObjById(emp.getEmpId());
		// չʾ�����б�
		List<Dep> list = depService.list();
		ActionContext.getContext().put("dList", list);
		return super.SUCCESS;
	}
	
	/**
	 *��֤validate 
	 */
	public void validateEmp_login(){
		System.out.println("������֤����");
		String rrCode = (String) session.getAttribute("rCode");
		if(StringUtils.isNotBlank(rCode)){
			if(StringUtils.equalsIgnoreCase(rrCode, rCode)){
				//��֤��ͨ��,��֤�û���
				if(StringUtils.isNotBlank(emp.getUsername())){
					//���emp�ĳ־û�����
					Emp emp = empService.getEmpByUsername(this.emp.getUsername());
					if(emp!=null){
						//�û������ڣ��������
						if(StringUtils.isNotBlank(this.emp.getPassword())){
							this.emp.setPassword(MD5Utils.md5(this.emp.getPassword()));
							String password = emp.getPassword();
							if(password.equals(this.emp.getPassword())){
								ActionContext.getContext().getSession().put("user", emp);
							}else{
							addFieldError("tip","�������");
							}
						}else{
							addFieldError("tip", "���벻��Ϊ��!");
						}
					}else{
						addFieldError("tip","���û���������!");
					}
				}else{
					addFieldError("tip","�û�������Ϊ�գ�");
				}
			}else{
				addFieldError("tip", "��֤���������!");
			} 
		}else{
				addFieldError("tip","��֤�벻��Ϊ��!");
		}
		
	}
	
	/**
	 * ������ʽ��¼
	 * @return
	 */
	public String emp_login(){
		return MAIN;
	}
	
	/**
	 * ���ڽ����¼ҳ��
	 * @return
	 */
	public String erp_toLogin(){
		return SUCCESS;
	}
	
	/**
	 * ������֤���ͼƬ
	 * @throws Exception
	 */
	public void ajax_emp_getImage() throws Exception{
	        BufferedImage img = new BufferedImage(68, 22,  
	  
	        BufferedImage.TYPE_INT_RGB);  
	  
	        // �õ���ͼƬ�Ļ�ͼ����    
	  
	        Graphics g = img.getGraphics();  
	  
	        Random r = new Random();  
	  
	        Color c = new Color(200, 150, 255);  
	  
	        g.setColor(c);  
	  
	        // �������ͼƬ����ɫ    
	  
	        g.fillRect(0, 0, 68, 22);  
	  
	        // ��ͼƬ��������ֺ���ĸ    
	  
	        StringBuffer sb = new StringBuffer();  
	        
	  
	        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
	  
	        int index, len = ch.length;  
	  
	        for (int i = 0; i < 4; i++) {  
	  
	            index = r.nextInt(len);  
	  
	            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt  
	  
	            (255)));  
	  
	            g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));  
	            // �����  ����ʹ�С                      
	  
	            g.drawString("" + ch[index], (i * 15) + 3, 18);  
	            //дʲô���֣���ͼƬ ��ʲôλ�û�    
	  
	            sb.append(ch[index]);  
	  
	        }  
	        //����֤���ֵ����session��
	        request.getSession().setAttribute("rCode", sb.toString());  
	        //����֤���ͼƬд�������
	        ImageIO.write(img, "JPG", response.getOutputStream());  
	}
}
