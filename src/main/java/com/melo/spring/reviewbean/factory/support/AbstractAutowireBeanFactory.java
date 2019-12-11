package com.melo.spring.reviewbean.factory.support;

import com.melo.spring.reviewbean.strategy.ConvertValueStrategy;
import com.melo.spring.reviewbean.strategy.support.StrategyBuilder;
import com.melo.spring.reviewbean.definition.BeanDefinition;
import com.melo.spring.reviewbean.definition.PropertyValue;
import com.melo.spring.reviewbean.definition.RuntimeBeanReference;
import com.melo.spring.reviewbean.definition.TypedStringValue;
import com.melo.spring.reviewbean.utils.ReflectUtils;

import java.util.List;

public abstract class AbstractAutowireBeanFactory extends AbstractBeanFactory {
    @Override
    protected com.melo.spring.reviewbean.definition.BeanDefinition getBeanDefinition(String name) {
        return null;
    }

    @Override
    public Object createBean(com.melo.spring.reviewbean.definition.BeanDefinition beanDefinition) {
        //完成bean的创建
        Class<?> clazz = resolveClassName(beanDefinition.getClazzName());
        if(clazz == null){
            return null;
        }
        //bean的创建分三个步骤
        //STEP1：实例化bean
        Object singleton = createBeanInstance(clazz);
        //STEP2:属性填充
        populateBean(singleton,beanDefinition);
        //STEP3:初始化bean
        initBean(singleton,beanDefinition);
        return singleton;
    }

    private void initBean(Object singleton, com.melo.spring.reviewbean.definition.BeanDefinition beanDefinition) {
        String initMethod = beanDefinition.getInitMethod();
        com.melo.spring.reviewbean.utils.ReflectUtils.invokeMethod(singleton,initMethod);
    }

    private void populateBean(Object singleton, BeanDefinition beanDefinition) {
        List<com.melo.spring.reviewbean.definition.PropertyValue> propertyValues = beanDefinition.getPropertyValues();
        for(PropertyValue propertyValue : propertyValues){
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            Object valueToUse = null;
            if(value instanceof com.melo.spring.reviewbean.definition.TypedStringValue){
                com.melo.spring.reviewbean.definition.TypedStringValue tv = (TypedStringValue) value;
                //策略模式
                ConvertValueStrategy strategy = StrategyBuilder.buildStrategy(tv.getTargetType());
                if(strategy == null){
                    return;
                }
                valueToUse = strategy.convertValue(tv.getValue());
            }else if(value instanceof com.melo.spring.reviewbean.definition.RuntimeBeanReference){
                com.melo.spring.reviewbean.definition.RuntimeBeanReference rt = (RuntimeBeanReference)value;
                valueToUse = getBean(rt.getRef());
            }else{

            }
            //利用反射设置bean属性
            com.melo.spring.reviewbean.utils.ReflectUtils.setProperty(singleton,name,valueToUse);
        }
    }

    private Object createBeanInstance(Class<?> clazz) {
        //TODO 可以根据bean标签的配置选择使用实例工厂去创建bean
        //TODO 可以根据bean标签的配置选择使用静态工厂去创建Bean

        return ReflectUtils.createObject(clazz);
    }

    private Class<?> resolveClassName(String clazzName) {
        try {
            return Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
