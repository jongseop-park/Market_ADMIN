package com.adcmarket.admin.product.controller;


import com.adcmarket.admin.product.domain.ProductVO;
import com.adcmarket.admin.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProductService productService;

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
}
