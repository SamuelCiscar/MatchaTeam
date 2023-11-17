package com.example.matchateam.Beans;

import java.util.ArrayList;

public class CommandProductBean {
    private CommandeBean command;
    private ArrayList<ProductListBean> productList;

    public CommandProductBean(CommandeBean command, ArrayList<ProductListBean> productList) {
        this.command = command;
        this.productList = productList;
    }

    public CommandProductBean() {
    }

    public CommandeBean getCommand() {
        return command;
    }

    public void setCommand(CommandeBean command) {
        this.command = command;
    }

    public ArrayList<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<ProductListBean> productList) {
        this.productList = productList;
    }
}
