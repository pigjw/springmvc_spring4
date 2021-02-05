package com.lsm.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWord {
    /**
     * 1.使用 requestmapping 来映射请求  作用是为控制器指定处理那些url请求
     * 2.返回值会通过视图解析器解析为实际的物理视图 对于InternalResourceViewResolver而言 视图解析器会做如下的解析
     * 通过prefix+returnVal+后缀这样的方式得到实际的物理视图 然后会做转发操作
     *  prefix:/WEB-INF/views/ + 返回值 success + 后缀:.jsp == /WEB-INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
}
