package com.example.group_project_mobile;

import java.util.ArrayList;
import java.util.List;

public class OrdersList {
    List<Order> ordList = new ArrayList<>();

    public void addOrder(Order order) {
        ordList.add(order);
    }

    public String toString(){
        String str  = "" ;
        for (Order ob: ordList) {
            str+="TYPE:"+ob.getType()+" => Name :"+ob.getName()+"\n";
        }
        return str;
    }
}
