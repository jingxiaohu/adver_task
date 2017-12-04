package com.pyb.mvc.weixin.bean;

/**
 * 类名: CommonButton </br>
 * 包名： com.souvc.weixin.menu
 * 描述: 子菜单项 :没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。 </br>
 * 开发人员： souvc  </br>
 * 创建时间：  2015-12-1 </br>
 * 发布版本：V1.0  </br>
 */
public class CommonButton extends Button {
    //菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
    private String type="view";
    private String key;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
