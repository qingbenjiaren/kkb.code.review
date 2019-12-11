package com.melo.springmvc.mapping.iface;

import javax.servlet.http.HttpServletRequest;

public interface HandlerMapping {
    Object getHandler(HttpServletRequest req);

}
