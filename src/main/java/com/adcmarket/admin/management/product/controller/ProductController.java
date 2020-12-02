package com.adcmarket.admin.management.product.controller;


import com.adcmarket.admin.management.product.domain.Criteria;
import com.adcmarket.admin.management.product.domain.PageMaker;
import com.adcmarket.admin.management.product.domain.ProductVO;
import com.adcmarket.admin.management.product.service.ProductService;
import com.adcmarket.admin.test.domain.MenuVO;
import com.adcmarket.admin.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProductService productService;

    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping(value = "/insert/product",  method = RequestMethod.POST)
    public void insertProduct(@RequestParam("rep_image") MultipartFile file,
                              @RequestParam("sub_image1") MultipartFile[] subFile,
                        @ModelAttribute ProductVO productVO) {

            logger.info("=============================");
            logger.info("파일 업로드");
            logger.info("cateCode : " + productVO.getCateCode());
            logger.info(file.getOriginalFilename());
            logger.info(String.valueOf(subFile.length));
            logger.info("=============================");

            productService.insertProduct(productVO, file, subFile);
    }

    @RequestMapping("/listProduct")
    public String listProduct(Criteria cri, Model model) {
        List<MenuVO> menuVOList = testService.selectMenuList();
        model.addAttribute("menu", menuVOList);

        List<ProductVO> productVOS = productService.selectProductList(cri);
        model.addAttribute("productList", productVOS);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(productService.countProductList());
        model.addAttribute(pageMaker);

        return "admin/productList";
    }
}
