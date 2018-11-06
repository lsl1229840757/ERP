package com.lsl.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.lsl.model.Emp;
import com.lsl.model.OrderDetail;
import com.lsl.model.OrderModel;
import com.lsl.query.OrderModelQuery;
import com.lsl.service.OrderModelService;
import com.lsl.service.ProductService;
import com.lsl.service.SupplierService;
import com.lsl.utils.ERPConstant;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class OrderModelAction extends BaseAction {
	
	/**
	 * 接受订单的参数
	 */
	
	private Integer[] productId;
	private Double[] detailPrice;
	private Integer[] detailNum;
	private Integer[] productType;
	private ProductService productService;
	private String note;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer[] getProductType() {
		return productType;
	}

	public void setProductType(Integer[] productType) {
		this.productType = productType;
	}

	public Integer[] getProductId() {
		return productId;
	}

	public void setProductId(Integer[] productId) {
		this.productId = productId;
	}

	public Double[] getDetailPrice() {
		return detailPrice;
	}

	public void setDetailPrice(Double[] detailPrice) {
		this.detailPrice = detailPrice;
	}

	public Integer[] getDetailNum() {
		return detailNum;
	}

	public void setDetailNum(Integer[] detailNum) {
		this.detailNum = detailNum;
	}

	private SupplierService supplierService;
	
	private OrderModel order = new OrderModel();

	private OrderModelService orderModelService;
	
	
	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}

	public OrderModelService getOrderModelService() {
		return orderModelService;
	}

	public void setOrderModelService(OrderModelService orderModelService) {
		this.orderModelService = orderModelService;
	}
	
	private OrderModelQuery query = new OrderModelQuery();
	
	public void setQuery(OrderModelQuery query) {
		this.query = query;
	}
	
	public OrderModelQuery getQuery() {
		return query;
	}
	
	public String orderModel_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		Page page = orderModelService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}
	
	public String orderModel_checkList(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		Page page = orderModelService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String orderModel_input(){
		ActionContext.getContext().put("suppliers", supplierService.list());
		return super.SUCCESS;
	}
	
	public String orderModel_orderDetails(){
		order = orderModelService.getObjById(query.getOrderId());
		return SUCCESS;
	}

	public String orderModel_auditOrder() throws IOException{
		return SUCCESS;
	}
	
	public void ajax_orderModel_auditOrderText() throws IOException{
		/**
		 * Ajax接收orderText ajax_orderModel_{1}
		 */
		Emp checker = (Emp)ActionContext.getContext().getSession().get("user");
		orderModelService.updateAuditOrder(checker, order, note);
		response.getWriter().write("success");
	}
	
	public void ajax_orderModel_submitOrder(){
		// 完成参数的组装
		OrderModel order = new OrderModel();
		Date now = new Date();
		order.setOrderNum(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(now));
		Emp emp = (Emp)ActionContext.getContext().getSession().get("user");
		order.setCreatorEmp(emp);
		order.setCreateTime(now);
		order.setOrderType(Integer.valueOf(ERPConstant.ORDER_TYPE_BUY));
		order.setOrderState(Integer.valueOf(ERPConstant.ORDER_TYPE_BUY_AUDIT));
		Integer totalNum = 0;
		double totalPrice = 0;
		Set<OrderDetail> ods = new HashSet<OrderDetail>();
		for(int i = 0;i < productType.length;i++){
			OrderDetail od = new OrderDetail();
			totalNum += detailNum[i];
			totalPrice += detailNum[i] * detailPrice[i];
			od.setDetailNum(detailNum[i]);
			od.setDetailPrice(detailPrice[i]);
			od.setProduct(productService.getObjById(productId[i]));
			// 这里设置了一对多的关系就不需要再设置订单的Id了,但是需要在orderModel的关系映射中设置级联操作
			ods.add(od);
		}	
		order.setDetails(ods);
		order.setTotalNum(totalNum);
		order.setTotalPrice(totalPrice);
		order.setSupplier(supplierService.getObjById(this.order.getSupplierId()));
		if(orderModelService.saveOrderMOdel(order)){
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
}
