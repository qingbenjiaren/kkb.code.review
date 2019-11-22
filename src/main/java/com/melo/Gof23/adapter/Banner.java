package com.melo.Gof23.adapter;

public class Banner {
    private String name;
    public Banner(String name){
        this.name = name;
    }
    public void showWithPattern(){
        System.out.println("*"+name+"*");
    }
    public void showWithAster(){
        System.out.println("("+name+")");
    }
    private void self(){
        System.out.println(name);
    }
}
