package chapter7.com.alibaba.dubbo.demo.provider;

import chapter7.com.alibaba.dubbo.demo.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}