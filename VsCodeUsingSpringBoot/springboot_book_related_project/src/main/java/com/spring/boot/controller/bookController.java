package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class bookController
 
{
    @RequestMapping( value ="/books",method = RequestMethod.GET)
    @ResponseBody
    public String getBooks()
    {
        return "This is testing book 1st";
    }
    
}
