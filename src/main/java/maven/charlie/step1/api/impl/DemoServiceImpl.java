package maven.charlie.step1.api.impl;

import java.util.ArrayList;
import java.util.List;

import maven.charlie.step1.api.DemoService;
import maven.charlie.step1.bean.User;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        User u1 = new User();
        u1.setName("hejingyuan");
        u1.setAge(20);
        u1.setSex("f");

        User u2 = new User();
        u2.setName("xvshu");
        u2.setAge(21);
        u2.setSex("m");


        list.add(u1);
        list.add(u2);

        return list;
    }
}
