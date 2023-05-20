package com.example.soolpandabackend.wishlist;

import com.example.soolpandabackend.product.ProductVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WishMapper {

    //찜 누르기
    @Insert("insert into tb_wishlist values (null,#{user_id},#{prod_id})")
    public int addWish(WishVO wish);

    //찜눌렀나 안눌렀나
    @Select("select count(*) from tb_wishlist where user_id=#{user_id} and prod_id=#{prod_id}")
    public int isLike(WishVO wish);

    //찜 지우기
    @Delete("delete from tb_wishlist where user_id = #{user_id} and prod_id = #{prod_id} ")
    public int deleteWish(WishVO wish);

    // 상품 찜 수 조회
    @Select("select count(*) as count from tb_wishlist where prod_id = #{prod_id}")
    public int wishCount(WishVO wish);

    // 찜 목록 조회
    @Select("SELECT prod_num FROM tb_product WHERE prod_num IN (SELECT prod_id FROM tb_wishlist where user_id = #{user_id})") //select
    public List<ProductVO> wishList(WishVO wish);
}