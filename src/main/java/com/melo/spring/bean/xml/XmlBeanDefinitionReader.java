package com.melo.spring.bean.xml;

import com.melo.spring.bean.factory.registry.BeanDefinitionRegistry;
import com.melo.spring.bean.utils.DocumentReader;
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
