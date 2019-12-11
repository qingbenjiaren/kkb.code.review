package com.melo.springmvc.servlet;

import com.melo.spring.bean.resource.ClasspathResource;
import com.melo.spring.bean.xml.XmlBeanDefinitionReader;
import com.melo.spring.bean.factory.support.DefaultListableBeanFactory;
import com.melo.springmvc.adapter.iface.HandlerAdapter;
import com.melo.springmvc.mapping.iface.HandlerMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DispatchServlet extends BaseServlet {
    List<HandlerMapping> handlerMappings = new ArrayList<>();
    List<HandlerAdapter> handlerAdapters = new ArrayList<>();
    private DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    @Override
    public void init(ServletConfig config) throws ServletException {
        String location = config.getInitParameter("contextConfigLocation");
        initBeanFactory(location);
        initHandlerMapping();
        initHandlerAdapter();
    }

    private void initBeanFactory(String location) {
        new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(new ClasspathResource(location).getResource());
    }

    private void initHandlerMapping(){
       handlerMappings = beanFactory.getBeansByType(HandlerMapping.class);
    }


    private Class<?> resolveClass(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void initHandlerAdapter(){
        handlerAdapters = beanFactory.getBeansByType(HandlerAdapter.class);
    }
    @Override
    public void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object handler = getHandler(req);
        if(handler == null){
            return;
        }
        HandlerAdapter ha = getAdapter(handler);
        if(ha == null){
            return;
        }
        ha.handleRequest(handler,req,resp);
    }
    private HandlerAdapter getAdapter(Object handler) {
        for(HandlerAdapter ha : handlerAdapters){
            if(ha.support(handler)){
                return ha;
            }
        }
        return null;
    }

    private Object getHandler(HttpServletRequest req) {
        for(HandlerMapping hm : handlerMappings){
            Object handler = hm.getHandler(req);
            if(handler != null){
                return handler;
            }
        }
        return null;
    }
}
