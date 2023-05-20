package com.example.soolpandabackend.wishlist;

import com.example.soolpandabackend.product.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishServiceImpl implements WishService {
	
	WishMapper mapper;

	public WishServiceImpl(WishMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int addWish(WishVO wish) {
		return mapper.addWish(wish);
	}
	public int isLike(WishVO wish){
		return mapper.isLike(wish);
	}

	@Override
	public int deleteWish(WishVO wish){
		return mapper.deleteWish(wish);
	}

	@Override
	public int wishCount(WishVO wish){
		return mapper.wishCount(wish);
	}

	@Override
	public List<ProductVO> wishList(WishVO wish) {
		List<ProductVO> productvo = mapper.wishList(wish);
		return productvo;
	}
}
