package com.lsm.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS = "success";

    /**
     * @RequestParam 来映射请求参数
     * value 值即为请求参数的参数名
     * requird 该参数是否是必须的
     * defaultvalue 该参数的默认值 默认值是必须的
     * @param username
     * @param age
     * @return
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "age",required = false,defaultValue = "0") int age ){
        System.out.println("username:"+username+",age:"+age);
        return SUCCESS;
    }





    /**
     * Rest 风格的URL
     * 以CRUD为例
     * 新增：/order POST
     * 修改：/order/1 PUT  update?id=1
     * 获取：/order/1 GET   get?id=1
     * 删除：/order/1 DELETE delete?id=1
     *
     * 如何发送PUT请求和delete请求
     * 1.需要配置HiddenHttpMethodFilter
     * 2.需要发送post请求
     * 3.需要在发送post请求时携带一个 name="_method"的隐藏域，值为delete或者put就可以了
     *
     * 在springmvc中如何获取到id？
     * 需要 @PathVariable(value = "id")
     * @param id
     * @return
     */

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable(value = "id") Integer id){
        System.out.println("testRest-PUT:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable(value = "id") Integer id){
        System.out.println("testRest-DELETE:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRest(){
        System.out.println("testRest-POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRest(@PathVariable(value = "id") Integer id){
        System.out.println("testRest-GET:"+id);
        return SUCCESS;
    }
    /**
     * @Variable 可以来映射URL中的占位符到目标方法的参数中
     * @param id
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") Integer id){
        System.out.println("testPathVariable:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testAntPath/*/abc")
    public String testAntPath(){
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 了解:可以使用params和headers来更加精确的映射请求 params和headers支持简单的表达式
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeaders",params = {"username","age=10"}
    ,headers = {"Accept-Language=zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 使用method属性来指定请求方式
     * @return
     */
    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }



    /**
     * requestMapping 除了修饰方法之外 还可以用来修饰类
     * 类出的：提供初步的映射信息  相当于WEB应用的根目录
     * 方法出的：提供进一步细分映射信息 相对于类定义处的URL 若类处没标记Resquestmapping 则方法处就是根目录
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
