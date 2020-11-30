package com.adcmarket.admin.product.service;

import com.adcmarket.admin.product.domain.CategoryVO;
import com.adcmarket.admin.product.domain.ProductVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public void insertProduct(ProductVO productVO, MultipartFile file, MultipartFile[] subFile);
    public List<CategoryVO> selectCategory();
}
