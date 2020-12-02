package com.adcmarket.admin.management.product.mapper;

import com.adcmarket.admin.management.product.domain.Criteria;
import com.adcmarket.admin.management.product.domain.ProductVO;
import com.adcmarket.admin.management.product.domain.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    void insertProduct(ProductVO productVO);
    List<CategoryVO> selectCategory();

    List<ProductVO> selectProductList(Criteria criteria);
    int countProductList();

}
