package com.melo.springmvc.controller;

import com.melo.springmvc.annotation.Controller;
import com.melo.springmvc.annotation.RequestMapping;
import com.melo.springmvc.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @ResponseBody
    public String queryUser(String id,String name){
        return id + name;
    }
}
