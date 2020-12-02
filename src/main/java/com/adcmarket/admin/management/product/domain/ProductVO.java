package com.adcmarket.admin.management.product.domain;

public class ProductVO {
    private int seq;
    private String name;
    private String brand;
    private int price;
    private String summaryDesc;
    private String detailDesc;
    private String sellYn;
    private String displayYn;
    private String cateCode;

    private String image;
    private String subImage1;
    private String subImage2;
    private String subImage3;
    private String subImage4;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubImage1() {
        return subImage1;
    }

    public void setSubImage1(String subImage1) {
        this.subImage1 = subImage1;
    }

    public String getSubImage2() {
        return subImage2;
    }

    public void setSubImage2(String subImage2) {
        this.subImage2 = subImage2;
    }

    public String getSubImage3() {
        return subImage3;
    }

    public void setSubImage3(String subImage3) {
        this.subImage3 = subImage3;
    }

    public String getSubImage4() {
        return subImage4;
    }

    public void setSubImage4(String subImage4) {
        this.subImage4 = subImage4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSummaryDesc() {
        return summaryDesc;
    }

    public void setSummaryDesc(String summaryDesc) {
        this.summaryDesc = summaryDesc;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getSellYn() {
        return sellYn;
    }

    public void setSellYn(String sellYn) {
        this.sellYn = sellYn;
    }

    public String getDisplayYn() {
        return displayYn;
    }

    public void setDisplayYn(String displayYn) {
        this.displayYn = displayYn;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
