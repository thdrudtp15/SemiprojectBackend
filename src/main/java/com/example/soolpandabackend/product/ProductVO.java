package com.example.soolpandabackend.product;

import lombok.Data;

@Data
public class ProductVO {
	private int prod_num;
	private String user_id;
	private String prod_name;
	private String prod_category;
	private float prod_abv;
	private int prod_volume;
	private int prod_price;
	private int prod_stock;
	private String prod_tag;
	private String prod_info;
	private String prod_date;
	private int prod_readcount;
	private int prod_wish;
	private int prod_shipping;
	private String prod_images;
	private int prod_vCount;
}
