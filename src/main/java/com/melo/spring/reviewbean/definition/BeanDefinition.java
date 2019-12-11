package com.melo.spring.reviewbean.definition;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    private String beanName;
    private String clazzName;
    private String scope;
    private String initMethod;
    private List<com.melo.spring.reviewbean.definition.PropertyValue> propertyValues = new ArrayList<>();

    private static final String SCOPE_SINGLETON = "singleton";
    private static final String SCOPE_PROTOTYPE = "prototype";

    public BeanDefinition(String beanName, String clazzName) {
        this.beanName = beanName;
        this.clazzName = clazzName;
    }

    public void addPropertyValue(com.melo.spring.reviewbean.definition.PropertyValue pv){
        propertyValues.add(pv);
    }
    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(String initMethod) {
        this.initMethod = initMethod;
    }

    public List<com.melo.spring.reviewbean.definition.PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public boolean isSingleton(){
        return SCOPE_SINGLETON.equals(this.scope);
    }
    public boolean isPrototype(){
        return SCOPE_PROTOTYPE.equals(this.scope);
    }
}
