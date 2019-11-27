package com.melo.spring.bean.factory;

import java.util.List;

public interface ListableBeanFactory extends BeanFactory {

    public List<Object> getBeansByType(Class<?> type);

    public List<Object> getBeans();

    public List<String> getBeanNamesByType(Class<?> type);

    public List<String> getBeanNames();
}
