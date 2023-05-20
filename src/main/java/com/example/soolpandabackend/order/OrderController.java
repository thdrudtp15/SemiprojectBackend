package com.example.soolpandabackend.order;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	OrderServiceImpl OrderServiceImpl;
	public OrderController(OrderServiceImpl OrderServiceImpl) {
		this.OrderServiceImpl = OrderServiceImpl;
	}
	
	//제품 주문
	@RequestMapping("/Order")
	public int Order(@RequestBody OrderVO order) {
		int res = OrderServiceImpl.Order(order);
		return res;
	}
	
	//주문 내역 전체 조회
	@RequestMapping("/OrderList")
	public ArrayList<OrderVO> OrderList(@RequestBody OrderVO order){
		ArrayList<OrderVO> list = OrderServiceImpl.OrderList(order);
		return list;
	}
	
	//주문취소, 주문내역 삭제
	@RequestMapping("/OrderCancellation")
	public int OrderCancellation(@RequestBody OrderVO order) {
		int res = OrderServiceImpl.OrderCancellation(order);
		return res;
	}
	
	@RequestMapping("/SaleList")
	public ArrayList<OrderVO> SaleList(@RequestBody OrderVO order){
		ArrayList<OrderVO> list = OrderServiceImpl.SaleList(order);
		return list;
	}
	
	
	
}
