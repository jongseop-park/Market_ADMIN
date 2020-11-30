package com.adcmarket.admin.test.domain;

import java.util.List;

public class MenuVO {

    /** 상위 메뉴 코드 */
    private String parentSeq;

    /** 메뉴 코드 */
    private int seq;

    /** 메뉴명 */
    private String name;

    /** URL */
    private String link;

    private int level;

    private List<MenuVO> menuList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentSeq() {
        return parentSeq;
    }

    public void setParentSeq(String parentSeq) {
        this.parentSeq = parentSeq;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public List<MenuVO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }
}
