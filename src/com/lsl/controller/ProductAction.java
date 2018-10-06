package com.lsl.controller;
import java.util.List;
import java.util.Set;

import com.lsl.model.Product;
import com.lsl.model.ProductType;
import com.lsl.model.Supplier;
import com.lsl.query.ProductQuery;
import com.lsl.service.ProductService;
import com.lsl.service.SupplierService;
import com.lsl.utils.JsonArrayUtils;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class ProductAction extends BaseAction {
	
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private SupplierService supplierService;
	
	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public ProductService getProductService() {
		return productService;
	}

	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	private ProductQuery query = new ProductQuery();
	
	public void setQuery(ProductQuery query) {
		this.query = query;
	}
	
	public ProductQuery getQuery() {
		return query;
	}
	
	public String product_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		List<Supplier> list = supplierService.list();
		
		ActionContext.getContext().put("list", list);
		
		Page page = productService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String product_input(){
		//查询供应商
		List<Supplier> list = supplierService.list();
		ActionContext.getContext().put("list", list);
		return super.SUCCESS;
	}
	
	public void ajax_product_changeSupplier(){
		Supplier supplier = supplierService.getObjById(query.getSupplierId());
		Set<ProductType> pts = supplier.getPts();
		JsonArrayUtils.getProductsBySupplier(response, pts, new String[]{"supplier"});
	}
	public void ajax_product_add () throws Exception{
		productService.save(product);
		response.getWriter().print("success");
	}
	
}
