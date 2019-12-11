package com.melo.spring.reviewbean.factory.registry.support;

import com.melo.spring.reviewbean.factory.registry.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    @Override
    public void registerSingleton(String name, Object bean) {
        this.singletonObjects.put(name,bean);
    }
}
