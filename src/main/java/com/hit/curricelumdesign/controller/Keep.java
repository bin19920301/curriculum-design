package com.hit.curricelumdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xbr
 * @Date 2019-12-03
 * @ClassName keep
 * @Description
 */


@Controller
public class Keep {

   //@Autowired
    //private AdminMapper adminMapper;

    @RequestMapping(name = "/", method = RequestMethod.POST)
    @ResponseBody
    public String a() {
       // adminMapper.selectByPrimaryKey(1);
        return "a";
    }

}
