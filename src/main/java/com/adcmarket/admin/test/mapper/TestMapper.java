package com.adcmarket.admin.test.mapper;


import com.adcmarket.admin.test.domain.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    public List<MenuVO> selectMenuList();
}
