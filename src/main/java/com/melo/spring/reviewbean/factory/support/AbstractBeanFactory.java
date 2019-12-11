package com.melo.spring.reviewbean.factory.support;

import com.melo.spring.reviewbean.factory.registry.support.DefaultSingletonBeanRegistry;
import com.melo.spring.reviewbean.definition.BeanDefinition;
import com.melo.spring.reviewbean.factory.AutowireCapableBeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements AutowireCapableBeanFactory {
    //定义bean的获取流程
    public Object getBean(String name){
        //从缓存取
        Object singleton = getSingleton(name);
        if(singleton == null){
            //找不到指定名称的BeanDefinition对象
            //此处使用到的就是抽象模板方法，只定流程，不去实现
            com.melo.spring.reviewbean.definition.BeanDefinition bd = getBeanDefinition(name);
            singleton = createBean(bd);
            if(bd.isSingleton()){
                registerSingleton(name,singleton);
            }
        }
        return singleton;
    }
    protected abstract BeanDefinition getBeanDefinition(String name);

}
