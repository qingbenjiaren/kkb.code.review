package com.melo.springmvc.adapter.iface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface HandlerAdapter {

    void handleRequest(Object handler,HttpServletRequest req, HttpServletResponse resp) throws IOException;

    boolean support(Object handler);
}
