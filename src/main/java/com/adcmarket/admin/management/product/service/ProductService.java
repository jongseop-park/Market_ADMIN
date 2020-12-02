package com.adcmarket.admin.management.product.service;

import com.adcmarket.admin.management.product.domain.Criteria;
import com.adcmarket.admin.management.product.domain.ProductVO;
import com.adcmarket.admin.management.product.domain.CategoryVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public void insertProduct(ProductVO productVO, MultipartFile file, MultipartFile[] subFile);
    public List<CategoryVO> selectCategory();
    List<ProductVO> selectProductList(Criteria criteria);
    int countProductList();
}
