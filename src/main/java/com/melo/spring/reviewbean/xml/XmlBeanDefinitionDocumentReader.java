package com.melo.spring.reviewbean.xml;

import com.melo.spring.reviewbean.factory.registry.BeanDefinitionRegistry;
import com.melo.spring.reviewbean.utils.ReflectUtils;
import com.melo.spring.reviewbean.definition.BeanDefinition;
import com.melo.spring.reviewbean.definition.PropertyValue;
import com.melo.spring.reviewbean.definition.RuntimeBeanReference;
import com.melo.spring.reviewbean.definition.TypedStringValue;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

import java.util.List;

public class XmlBeanDefinitionDocumentReader {
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionDocumentReader(BeanDefinitionRegistry beanDefinitionRegistry){
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void registerBeanDefinitions(Element rootElement) {
        //获取<bean>和自定义标签
        List<Element> elements = rootElement.elements();
        for(Element element : elements){
            String name = element.getName();
            if("bean".equals(name)){
                parseDefaultElement(element);
            }else{
                parseCustomElement(element);
            }
        }
    }

    private void parseCustomElement(Element element) {
    }

    private void parseDefaultElement(Element element) {
        try {
            String id = element.attributeValue("id");
            String name = element.attributeValue("name");
            String clazzName = element.attributeValue("class");
            if (StringUtils.isEmpty(clazzName)) {
                return;
            }
            Class<?> clazzType = Class.forName(clazzName);
            String initMethod = element.attributeValue("init-method");
            String scope = element.attributeValue("scope");
            //scope默认为singleton
            scope = scope != null && !scope.equals("") ? scope : "singleton";
            String beanName = id == null ? name == null ? clazzType.getSimpleName() : name : id;
            //创建BeanDefinition对象
            com.melo.spring.reviewbean.definition.BeanDefinition bd = new com.melo.spring.reviewbean.definition.BeanDefinition(beanName,clazzName);
            bd.setScope(scope);
            bd.setInitMethod(initMethod);
            //获取property集合
            List<Element> propertyElements  = element.elements();
            for(Element propertyElement : propertyElements){
                parsePropertyElement(bd,propertyElement);
            }
            beanDefinitionRegistry.registerBeanDefinition(beanName,bd);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void parsePropertyElement(BeanDefinition bd, Element propertyElement) {
        String name = propertyElement.attributeValue("name");
        String value = propertyElement.attributeValue("value");
        String ref = propertyElement.attributeValue("ref");
        //如果value和ref都有值直接返回
        if(StringUtils.isNotEmpty(value) && StringUtils.isNotEmpty(ref)){
            return;
        }
        com.melo.spring.reviewbean.definition.PropertyValue pv = null;
        if(StringUtils.isNotEmpty(value)){
            //因为spring配置文件中value都是String类型，而对象中的属性是各种各样的，所以需要储存类型
            com.melo.spring.reviewbean.definition.TypedStringValue tv = new TypedStringValue(value);
            Class<?> targetType = ReflectUtils.getTypeByFieldName(bd.getClazzName(),name);
            tv.setTargetType(targetType);
            pv = new com.melo.spring.reviewbean.definition.PropertyValue(name,tv);
            bd.addPropertyValue(pv);
        }else{
            com.melo.spring.reviewbean.definition.RuntimeBeanReference rb = new RuntimeBeanReference(ref);
            pv = new PropertyValue(name,rb);
            bd.addPropertyValue(pv);
        }
    }
}
