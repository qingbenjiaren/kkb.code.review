package com.melo.spring.reviewbean.factory.registry;

import com.melo.spring.reviewbean.definition.BeanDefinition;

public interface BeanDefinitionRegistry {

    public com.melo.spring.reviewbean.definition.BeanDefinition getBeanDefinition(String name);

    public void registerBeanDefinition(String name, BeanDefinition bd);
}
