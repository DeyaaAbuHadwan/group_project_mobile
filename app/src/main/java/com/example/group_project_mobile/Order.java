package com.example.group_project_mobile;

public class Order {
    String Type ;
    String name ;
    int imgSource ;

    public Order(String type, String name, int imgSource) {
        Type = type;
        this.name = name;
        this.imgSource = imgSource;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgSource() {
        return imgSource;
    }

    public void setImgSource(int imgSource) {
        this.imgSource = imgSource;
    }
}
