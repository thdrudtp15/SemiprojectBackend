package com.example.soolpandabackend.order;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

	//제품 주문
	@Insert("INSERT INTO tb_order (order_num, order_id, seller_id,prod_num ,prod_name, prod_price, prod_ea, order_name, order_date, order_postcode,order_addr,order_tel,order_message,order_image)"
			+ " VALUES (null,#{order_id}, #{seller_id},#{prod_num}, #{prod_name}, #{prod_price},#{prod_ea}, #{order_name}, now() ,#{order_postcode},#{order_addr},#{order_tel},#{order_message},#{order_image})")
	public int Order(OrderVO order);
		
	//주문 내역 전체 조회
	@Select("select order_num, order_id, seller_id,prod_num ,prod_name, prod_price, prod_ea, order_name, "
			+ "date_format(order_date,'%Y-%c-%e %H:%i:%s') as order_date, order_postcode,order_addr,order_tel,order_message,order_image "
			+ "from tb_order where order_id = #{order_id} order by order_date desc")
	public ArrayList<OrderVO> OrderList(OrderVO order);
	
	//주문 취소, 주문 내역 삭제
	@Delete("delete from tb_order where order_num = #{order_num}")
	public int OrderCancellation(OrderVO order);
	
	//4.2추가됨
	@Select("select order_num, order_id, seller_id,prod_num ,prod_name, prod_price, prod_ea, order_name, "
			+ "	date_format(order_date,'%Y-%c-%e %H:%i:%s') as order_date, order_postcode,order_addr,order_tel,order_message,order_image"
			+ " from tb_order where seller_id = #{seller_id} order by order_date asc")
	public ArrayList<OrderVO> SaleList(OrderVO order);
}
