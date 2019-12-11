package com.melo.spring.reviewbean.xml;

import com.melo.spring.reviewbean.factory.registry.BeanDefinitionRegistry;
import com.melo.spring.reviewbean.utils.DocumentReader;
import org.dom4j.Document;

import java.io.InputStream;

public class XmlBeanDefinitionReader {
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry){
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void loadBeanDefinitions(InputStream inputStream){
        Document document = DocumentReader.createDocument(inputStream);
        XmlBeanDefinitionDocumentReader reader = new XmlBeanDefinitionDocumentReader(beanDefinitionRegistry);
        reader.registerBeanDefinitions(document.getRootElement());
    }
}
