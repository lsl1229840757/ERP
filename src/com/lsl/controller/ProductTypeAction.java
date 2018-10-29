package com.lsl.controller;
import java.util.List;
import java.util.Set;

import com.lsl.model.Product;
import com.lsl.model.ProductType;
import com.lsl.model.Supplier;
import com.lsl.query.ProductTypeQuery;
import com.lsl.service.ProductTypeService;
import com.lsl.service.SupplierService;
import com.lsl.utils.JsonArrayUtils;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class ProductTypeAction extends BaseAction {
	
	private ProductType productType;
	
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	private ProductTypeService productTypeService;
	
	private SupplierService supplierService;
	
	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}
	
	private ProductTypeQuery query = new ProductTypeQuery();
	
	public void setQuery(ProductTypeQuery query) {
		this.query = query;
	}
	
	public ProductTypeQuery getQuery() {
		return query;
	}
	
	public String productType_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		List<Supplier> list = supplierService.list();
		ActionContext.getContext().put("list", list);
		Page page = productTypeService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String productType_input(){
		//得到全部的供應商
		List<Supplier> list = supplierService.list();
		ActionContext.getContext().put("list", list);
		return super.SUCCESS;
	}
	
	public void validateAjax_productType_add(){
		ProductType prod = null;
		prod = productTypeService.getProductTypeBySupplierId(productType);
		if(prod != null){
			this.addFieldError("tip","该商品类型已经存在!");
		}
	}
	
	public void ajax_productType_add () throws Exception{
		productTypeService.save(productType);
		response.getWriter().print("success");
	}
	public void ajax_productType_getProduct() throws Exception{
		ProductType pt = productTypeService.getObjById(query.getProductTypeId());
		Set<Product> products = pt.getProducts();
		JsonArrayUtils.getProductsBySupplier(response, products, new String[]{"products","supplier"}); //排除懒加载的属性防止jsonArr转换失败
	}
}
