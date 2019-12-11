package com.melo.spring.reviewbean.factory;

import com.melo.spring.reviewbean.definition.BeanDefinition;

public interface AutowireCapableBeanFactory extends BeanFactory{
     Object createBean(BeanDefinition beanDefinition);
}
