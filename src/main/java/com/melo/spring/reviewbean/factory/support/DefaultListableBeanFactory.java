package com.melo.spring.reviewbean.factory.support;

import com.melo.spring.reviewbean.definition.BeanDefinition;
import com.melo.spring.reviewbean.factory.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireBeanFactory implements BeanDefinitionRegistry {
    private Map<String, com.melo.spring.reviewbean.definition.BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    public com.melo.spring.reviewbean.definition.BeanDefinition getBeanDefinition(String name) {
        return beanDefinitionMap.get(name);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition bd) {
        this.beanDefinitionMap.put(name,bd);
    }
}
