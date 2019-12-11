package com.melo.springmvc.mapping;

import com.melo.springmvc.handler.AddUserHandler;
import com.melo.springmvc.handler.QueryUserHandler;
import com.melo.springmvc.mapping.iface.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SimpleHandlerMapping implements HandlerMapping {

    private Map<String,Object> urlMappings = new HashMap<>();

    public void init(){
        urlMappings.put("/addUser",new AddUserHandler());
        urlMappings.put("/queryUser",new QueryUserHandler());
    }
    @Override
    public Object getHandler(HttpServletRequest req) {
        String uri = req.getRequestURI();
        if(urlMappings.size() == 0){
            init();
        }
        return urlMappings.get(uri);
    }
}
