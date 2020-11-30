package com.adcmarket.admin.product.service.serviceImpl;

import com.adcmarket.admin.product.domain.CategoryVO;
import com.adcmarket.admin.product.domain.ProductVO;
import com.adcmarket.admin.product.mapper.ProductMapper;
import com.adcmarket.admin.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String UPLOAD_PATH = "C:\\Study\\fileupload";
    private static final String UPLOAD_PROJECT_PATH = "C:\\Users\\psy\\IdeaProjects\\adcMarket\\src\\main\\resources\\static\\img\\product";
    private static final String UPLOAD_DB_PATH = "/static/img/product/";
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProductMapper productMapper;

    @Override
    public void insertProduct(ProductVO productVO, MultipartFile file, MultipartFile[] subFile) {
        logger.info(file.getOriginalFilename());
        for(MultipartFile file1 : subFile) {
            logger.info(file1.getOriginalFilename());
        }

        List<MultipartFile> multipartFiles = new ArrayList<>();
        multipartFiles.add(file);
        for(MultipartFile multipartFile : subFile) {
            multipartFiles.add(multipartFile);
        }

        List<String> fileNames = saveFile(multipartFiles);
        String mainImage = UPLOAD_DB_PATH + fileNames.get(0);
        String subImage1 = "" , subImage2 = "", subImage3 = "", subImage4 = "";

        for(int i = 1 ; i< fileNames.size(); i++)  {
            switch(i) {
                case 1: subImage1 = UPLOAD_DB_PATH + fileNames.get(1); break;
                case 2: subImage2 = UPLOAD_DB_PATH + fileNames.get(2); break;
                case 3: subImage3 = UPLOAD_DB_PATH + fileNames.get(3); break;
                case 4: subImage4 = UPLOAD_DB_PATH + fileNames.get(4); break;
            }
        }

        productVO.setImage(mainImage);
        productVO.setSubImage1(subImage1);
        productVO.setSubImage2(subImage2);
        productVO.setSubImage3(subImage3);
        productVO.setSubImage4(subImage4);

        productMapper.insertProduct(productVO);
    }

    @Override
    public List<CategoryVO> selectCategory() {
        return productMapper.selectCategory();
    }

    private List<String> saveFile(List<MultipartFile> files) {
        UUID uuid = UUID.randomUUID();

        List<String> fileNames = new ArrayList<>();

        try {
            for(MultipartFile multipartFile : files) {
                String saveName = uuid + "_" + multipartFile.getOriginalFilename();
                fileNames.add(saveName);

                //File saveFile = new File(UPLOAD_PATH, saveName);
                File saveFile = new File(UPLOAD_PROJECT_PATH, saveName);
                multipartFile.transferTo(saveFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileNames;
    }
}
