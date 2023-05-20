package com.example.soolpandabackend.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductMapper mapper;

    public ProductServiceImpl(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductVO> getAllList() {
//		int start = (page_num -1)*limit;
        List<ProductVO> list = mapper.getAllList();
        return list;
    }

    @Override
    public int insertProduct(ProductVO prod) {
        mapper.insertProduct(prod);
        int res = prod.getProd_num();
        return res;
    }

    @Override
    public ProductVO getDetail(int prod_num) {
        ProductVO vo = mapper.getDetail(prod_num);
        return vo;
    }

    @Override
    public int modifyProduct(ProductVO prod) {
        int res = mapper.modifyProduct(prod);
        return res;
    }

    @Override
    public int deleteProduct(ProductVO prod) {
        int res = mapper.deleteProduct(prod);
        return res;
    }

    @Override
    public int getCount() {
        int res = mapper.getCount();
        return res;
    }

    @Override
    public int insertImages(ProductVO imgs) {
        int res = mapper.insertImages(imgs);
        return res;
    }

    @Override
    public void addViewCount(int prod_num) {
        mapper.addViewCount(prod_num);
    }

}
