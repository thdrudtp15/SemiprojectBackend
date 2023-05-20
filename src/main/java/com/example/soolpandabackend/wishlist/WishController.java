package com.example.soolpandabackend.wishlist;

import com.example.soolpandabackend.product.ProductVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishController {
	WishServiceImpl wishServiceImpl;

	public WishController(WishServiceImpl wishServiceImpl) {
		this.wishServiceImpl = wishServiceImpl;
	}

	@RequestMapping("/like/insert")
	public int addWish(@RequestBody WishVO wish) {
		System.out.println("insert : "+wish);
		int res= wishServiceImpl.addWish(wish);
		System.out.println("insert : "+res);;
		return res;
	}
	@RequestMapping("/like/islike")
	public int isLike(@RequestBody WishVO wish){
		System.out.println("isLike? : "+ wish);
		int res = wishServiceImpl.isLike(wish);
		System.out.println("isLike? : "+ res);
		return res;
	}

	@RequestMapping("/like/delete")
	public int deleteWish(@RequestBody WishVO wish){
		System.out.println("del : "+ wish);
		int res = wishServiceImpl.deleteWish(wish);
		System.out.println("del : "+res);
		return  res;
	}

	@RequestMapping("/like/cnt")
	public int wishCount(@RequestBody WishVO wish){
		int res = wishServiceImpl.wishCount(wish);
		return res;
	}

	@RequestMapping("/like/list")
	public ProductVO[] wishList(@RequestBody WishVO wish){
		List<ProductVO> productvo = wishServiceImpl.wishList(wish);
		System.out.println(productvo);
		ProductVO[] result = productvo.toArray(new ProductVO[productvo.size()]);
		return result;
	}
}