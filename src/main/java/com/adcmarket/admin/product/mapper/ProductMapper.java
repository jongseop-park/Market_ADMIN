package com.adcmarket.admin.product.mapper;

import com.adcmarket.admin.product.domain.CategoryVO;
import com.adcmarket.admin.product.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    public void insertProduct(ProductVO productVO);
    public List<CategoryVO> selectCategory();
}
