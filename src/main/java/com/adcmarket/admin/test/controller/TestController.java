package com.adcmarket.admin.test.controller;

import com.adcmarket.admin.management.product.domain.CategoryVO;
import com.adcmarket.admin.management.product.service.ProductService;
import com.adcmarket.admin.test.domain.MenuVO;
import com.adcmarket.admin.test.service.TestService;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    ProductService productService;

    @Autowired
    TestService testService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String index(Model model){
        List<MenuVO> menuVOS1 = testService.selectMenuList();

        for(MenuVO menuVO : menuVOS1) {
            logger.info(String.valueOf(menuVO.getMenuList().size()));
        }


        logger.info("menu length : " + menuVOS1.size());
        model.addAttribute("menu", menuVOS1);

        return "/admin/index";
    }


    @RequestMapping("/addProduct")
    public String addProduct(Model model) {
        logger.info("get product add");

        List<CategoryVO> category = null;
        category = productService.selectCategory();

        logger.info(String.valueOf(category.size()));
        JSONArray jsonArray = new JSONArray();
        model.addAttribute("category", jsonArray.fromObject(category));

        return "/admin/addForm";
    }
}
