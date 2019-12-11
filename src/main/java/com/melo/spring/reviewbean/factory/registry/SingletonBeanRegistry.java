package com.melo.spring.reviewbean.factory.registry;

public interface SingletonBeanRegistry {

    public Object getSingleton(String name);

    public void registerSingleton(String name,Object bean);
}
