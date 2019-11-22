package com.melo.Gof23.factorymethod;

public class IdCardFactory extends Factory {
    @Override
    public Product createProduct(String owner) {
        System.out.println(owner+"创建产品成功");
        return new IdCardProduct(owner);
    }

    @Override
    public void registerProduct(Product p) {
        System.out.println("产品注册成功");
    }
}
