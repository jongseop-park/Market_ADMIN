package com.adcmarket.admin.test.service.serviceImpl;

import com.adcmarket.admin.test.domain.MenuVO;
import com.adcmarket.admin.test.mapper.TestMapper;
import com.adcmarket.admin.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<MenuVO> selectMenuList() {
        List<MenuVO> list = testMapper.selectMenuList();

        for(int i=0; i<list.size(); i++) {
            logger.info("1 > " + list.get(i).getName());
            logger.info(String.valueOf(list.get(i).getSeq()));

            for(int j=0; j< list.get(i).getMenuList().size(); j++) {
                logger.info("2 > " + list.get(i).getMenuList().get(j).getName());
                logger.info(String.valueOf(list.get(i).getMenuList().get(j).getSeq()));
            }
        }

        return testMapper.selectMenuList();
    }
}
