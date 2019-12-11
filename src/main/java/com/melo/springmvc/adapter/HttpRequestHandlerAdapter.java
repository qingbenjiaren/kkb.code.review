package com.melo.springmvc.adapter;


import com.melo.springmvc.adapter.iface.HandlerAdapter;
import com.melo.springmvc.handler.iface.HttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpRequestHandlerAdapter implements HandlerAdapter {
    @Override
    public void handleRequest(Object handler, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ((HttpRequestHandler) handler).handleRequest(req,resp);
    }

    @Override
    public boolean support(Object handler) {
        return handler instanceof HttpRequestHandler;
    }
}
