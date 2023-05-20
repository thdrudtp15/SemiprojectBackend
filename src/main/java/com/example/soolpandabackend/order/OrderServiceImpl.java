package com.example.soolpandabackend.order;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

		OrderMapper mapper;
		public OrderServiceImpl(OrderMapper mapper) {
			this.mapper = mapper;
		}
	
	@Override
	public int Order(OrderVO order) {
		int res = mapper.Order(order);
		return res;
	}

	@Override
	public ArrayList<OrderVO> OrderList(OrderVO order) {
		ArrayList<OrderVO> list = mapper.OrderList(order);
		return list;
	}

	@Override
	public int OrderCancellation(OrderVO order) {
		int res = mapper.OrderCancellation(order);
		return res;
	}

	@Override
	public ArrayList<OrderVO> SaleList(OrderVO order) {
		ArrayList<OrderVO> salelist = mapper.SaleList(order);
		return salelist;
	}

}
