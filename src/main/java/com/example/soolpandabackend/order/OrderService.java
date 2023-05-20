package com.example.soolpandabackend.order;

import java.util.ArrayList;

public interface OrderService {

	
	
	
	
	public ArrayList<OrderVO> OrderList(OrderVO order);
	public int Order(OrderVO order);
	public int OrderCancellation(OrderVO order);
	public ArrayList<OrderVO> SaleList(OrderVO order);
}
