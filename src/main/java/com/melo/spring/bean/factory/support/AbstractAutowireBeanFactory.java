package com.melo.spring.bean.factory.support;

import com.melo.spring.bean.definition.BeanDefinition;
import com.melo.spring.bean.definition.PropertyValue;
import com.melo.spring.bean.definition.RuntimeBeanReference;
import com.melo.spring.bean.definition.TypedStringValue;
import com.melo.spring.bean.strategy.ConvertValueStrategy;
import com.melo.spring.bean.strategy.support.StrategyBuilder;
import com.melo.spring.bean.utils.ReflectUtils;

import java.util.List;

public abstract class AbstractAutowireBeanFactory extends AbstractBeanFactory {
    @Override
    protected BeanDefinition getBeanDefinition(String name) {
        return null;
    }

    @Override
    public Object createBean(BeanDefinition beanDefinition) {
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

    private void initBean(Object singleton, BeanDefinition beanDefinition) {
        String initMethod = beanDefinition.getInitMethod();
        ReflectUtils.invokeMethod(singleton,initMethod);
    }

    private void populateBean(Object singleton, BeanDefinition beanDefinition) {
        List<PropertyValue> propertyValues = beanDefinition.getPropertyValues();
        for(PropertyValue propertyValue : propertyValues){
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            Object valueToUse = null;
            if(value instanceof TypedStringValue){
                TypedStringValue tv = (TypedStringValue) value;
                //策略模式
                ConvertValueStrategy strategy = StrategyBuilder.buildStrategy(tv.getTargetType());
                if(strategy == null){
                    return;
                }
                valueToUse = strategy.convertValue(tv.getValue());
            }else if(value instanceof RuntimeBeanReference){
                RuntimeBeanReference rt = (RuntimeBeanReference)value;
                valueToUse = getBean(rt.getRef());
            }else{

            }
            //利用反射设置bean属性
            ReflectUtils.setProperty(singleton,name,valueToUse);
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
