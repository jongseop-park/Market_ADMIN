package com.adcmarket.admin.controller;

import com.adcmarket.admin.product.domain.CategoryVO;
import com.adcmarket.admin.product.service.ProductService;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String index(){
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
