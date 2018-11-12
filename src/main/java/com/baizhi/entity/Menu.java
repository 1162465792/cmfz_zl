package com.baizhi.entity;

import java.util.List;

public class Menu {
    private String id;
    private String name;
    private String iconCls;
    private String href;
    private String parent_id;
    private List<Menu> menus;
    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", menus=" + menus +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu() {
    }

    public Menu(String id, String name, String iconCls, String href, String parent_id, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.parent_id = parent_id;
        this.menus = menus;
    }
}
