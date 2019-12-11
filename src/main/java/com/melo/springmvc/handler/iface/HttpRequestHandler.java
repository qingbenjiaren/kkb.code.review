package com.melo.springmvc.handler.iface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface HttpRequestHandler {

    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
