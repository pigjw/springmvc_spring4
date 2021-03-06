package com.lsm.handlers;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;





/**
 * SessionAttributest这个注解会把请求参数同时放到请求域和session域里边
 * value是一个字符串数组
 */
//@SessionAttributes(value = {"user",""},types = {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS = "success";
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,
                            Map<String,Object> map){
        if(id != null){
            User user = new User(1,"lsiiming",
                    "123456","857854781@qq.com","12");
            System.out.println("从数据库中获取一个对象:"+user);
            map.put("user",user);
        }

    }

    /**
     * 运行流程
     * 1.执行 @ModelAttribute 注解修饰的方法：从数据库中取出对象，把对象放入到了map中 键为:user
     * 2.springmvc从map中取出User对象，并把表单的请求参数赋给该User对象的对应属性
     * 3.SpringMvc 把上述对象传入目标方法的参数
     *
     * 注意： 在@ModelAttribute 修饰的方法中，放入到Map时的健需要和目标方法入参类型的第一个字母小写的字符串一致
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改：" + user);
        return SUCCESS;
    }
    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是value属性值)
     * 还可以通过模型属性的对象类型指定那些模型属性需要放到会话中(实际上使用的是type属性值)
     * 这个注解只能放到类的上边
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map){
        User user = new User("lisiming","123456",
                "857854781@qq.com","24");
        map.put("user",user);
        map.put("school","dianxin");
        return SUCCESS;
    }

    /**
     * 处理模型数据的第二种方式
     * 目标方法可以添加map类型（实际上也可以model类型或者modelmap类型）的参数
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("111","222","333"));
        return SUCCESS;
    }

    /**
     * 处理模型数据的第一种方式
     * 目标方法的返回值可以是ModelAndView类型
     * 其中可以包含视图和模型信息
     * SpringMVC会把ModelAndView的model中的数据放到request的域对象中
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        //添加模型数据到modelAndView中
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }


    @RequestMapping("/testServletAPI")
    public  String testServletAPI(HttpServletRequest httpServletRequest,
                                  HttpServletResponse httpServletResponse){
        System.out.println("testServletAPI, "+httpServletRequest+","+httpServletResponse);
        return SUCCESS;
    }

    /**
     * springmvc 会按请求的参数名和POJO属性名称进行自动匹配
     * 自动为该对象填充属性值支持级联属性 pojo.city pojo.province
     * @param user
     * @return
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo:"+user);
        return SUCCESS;
    }

    /**
     * 了解
     * @CookieValue 映射一个Cookie值 属性同 @RequestParam
     * @param jsessionid
     * @return
     */
    @RequestMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String jsessionid){
        System.out.println("testCookieValue-jsessionid:"+jsessionid);
        return SUCCESS;
    }

    /**
     * @RequestHeader用法和@RequestParam相同  作用就是映射请求头信息
     * @param al
     * @return
     */
    @RequestMapping(value = "testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al){
        System.out.println("testRequestHeader:"+al);
        return SUCCESS;
    }

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
