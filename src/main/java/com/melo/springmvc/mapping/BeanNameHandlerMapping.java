package com.melo.springmvc.mapping;

import com.melo.spring.bean.aware.BeanFactoryAware;
import com.melo.spring.bean.definition.BeanDefinition;
import com.melo.spring.bean.factory.BeanFactory;
import com.melo.spring.bean.factory.ListableBeanFactory;
import com.melo.spring.bean.factory.support.DefaultListableBeanFactory;
import com.melo.springmvc.mapping.iface.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanNameHandlerMapping implements HandlerMapping, BeanFactoryAware {
    private Map<String,Object> urlHandlers = new HashMap<>();
    private DefaultListableBeanFactory beanFactory;
    public void init(){
        List<BeanDefinition> beanDefinitionList = beanFactory.getBeanDefinitions();
        for(BeanDefinition bd : beanDefinitionList){
            String beanName = bd.getBeanName();
            if(beanName.startsWith("/")){
                urlHandlers.put(beanName,beanFactory.getBean(beanName));
            }
        }
    };
    @Override
    public Object getHandler(HttpServletRequest req) {
        return null;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
}
