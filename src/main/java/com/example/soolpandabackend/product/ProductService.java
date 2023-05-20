package com.example.soolpandabackend.product;

import java.util.List;

public interface ProductService {
	public List<ProductVO> getAllList();
	public int insertProduct(ProductVO prod);
	public ProductVO getDetail(int prod_num);
	public int modifyProduct(ProductVO prod);
	public int deleteProduct(ProductVO prod);
	public int getCount();
	public int insertImages(ProductVO imgs);
	void addViewCount(int prod_num);

}
