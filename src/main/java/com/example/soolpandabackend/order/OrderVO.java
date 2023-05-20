package com.example.soolpandabackend.order;

import lombok.Data;

@Data
public class OrderVO {

	private String order_num;
	private String order_id;
	private String seller_id;
	private int prod_num;
	private String prod_name;
	private int prod_price;
	private int prod_ea;
	private String order_name;
	private String order_date;
	private String order_postcode;
	private String order_addr;
	private String order_tel;
	private String order_message;
	private String order_image;
	
	
	

}
