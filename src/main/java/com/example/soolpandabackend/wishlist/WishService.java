package com.example.soolpandabackend.wishlist;



import com.example.soolpandabackend.product.ProductVO;

import java.util.List;

public interface WishService {

	//찜추가
	public int addWish(WishVO wish);

	//찜 눌렀는지 안눌렀는지
	public int isLike(WishVO wish);

	// 찜 삭제
	public int deleteWish(WishVO wish);

	// 상품 찜 수 조회
	public int wishCount(WishVO wish);

	// 찜 목록 조회
	public List<ProductVO> wishList(WishVO wish);
}
