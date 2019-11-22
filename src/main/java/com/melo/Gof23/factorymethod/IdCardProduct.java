package com.melo.Gof23.factorymethod;

public class IdCardProduct implements Product{
    private String owner;
    public IdCardProduct(String owner){
        this.owner = owner;
    }
    @Override
    public void use() {
        System.out.println("用户 "+owner+" 正在使用产品...");
    }
}
