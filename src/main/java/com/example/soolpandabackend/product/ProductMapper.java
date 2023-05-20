package com.example.soolpandabackend.product;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
	@Select("select prod_num, user_id, prod_name, prod_category, prod_abv, prod_volume, prod_price, prod_stock, prod_tag, prod_info, "
			+ "date_format(prod_date, '%y-%m-%d') as prod_date, prod_readcount, prod_wish, prod_shipping, prod_images, prod_vCount from tb_product order by prod_num desc")
	public List<ProductVO> getAllList();

	@Insert("insert into tb_product values (null, #{user_id}, #{prod_name}, #{prod_category}, #{prod_abv}, "
			+ "#{prod_volume}, #{prod_price}, #{prod_stock}, #{prod_tag}, #{prod_info}, #{prod_date}, "
			+ "#{prod_readcount}, #{prod_wish}, #{prod_shipping}, null, 0)")
	@Options(useGeneratedKeys = true, keyProperty = "prod_num")
	public int insertProduct(ProductVO prod);

	@Select("select prod_num, user_id, prod_name, prod_category, prod_abv, prod_volume, prod_price, prod_stock, prod_tag, prod_info, "
			+ "date_format(prod_date, '%y-%m-%d') as prod_date, prod_readcount, prod_wish, prod_shipping, prod_images, prod_vCount from tb_product where prod_num = #{prod_num}")
	public ProductVO getDetail(int prod_num);

	@Update("update tb_product set prod_name=#{prod_name}, prod_category=#{prod_category}, prod_abv=#{prod_abv}, prod_volume=#{prod_volume}, prod_price=#{prod_price}, prod_stock=#{prod_stock}, prod_tag=#{prod_tag}, prod_info=#{prod_info}, "
			+ "prod_date=now(), prod_readcount=#{prod_readcount}, prod_wish=#{prod_wish}, prod_shipping=#{prod_shipping} where prod_num=#{prod_num}")
	public int modifyProduct(ProductVO prod);

	@Delete("delete from tb_product where prod_num = #{prod_num}")
	public int deleteProduct(ProductVO prod);

	@Select("select count(*) as count from tb_product")
	public int getCount();

	@Insert("update tb_product set prod_images=#{prod_images} where prod_num=#{prod_num}")
	public int insertImages(ProductVO imgs);

	@Update("UPDATE tb_product SET prod_vCount = prod_vCount + 1 WHERE prod_num = #{prod_num}")
	void addViewCount(int prod_num);
}
