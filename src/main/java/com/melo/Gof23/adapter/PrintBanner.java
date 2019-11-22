package com.melo.Gof23.adapter;

public class PrintBanner extends Banner implements Print {
    public PrintBanner(String name) {
        super(name);
    }

    @Override
    public void printWeak() {
        System.out.println("弱适配");
        showWithPattern();
    }

    @Override
    public void printStrong() {
        System.out.println("强适配");
        showWithAster();
    }
}
