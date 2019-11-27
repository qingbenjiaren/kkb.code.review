package com.melo.spring.bean.factory.registry;

import com.melo.spring.bean.definition.BeanDefinition;

public interface BeanDefinitionRegistry {

    public BeanDefinition getBeanDefinition(String name);

    public void registerBeanDefinition(String name,BeanDefinition bd);
}
