package maven.charlie.step1.api;

import java.util.List;

import maven.charlie.step1.bean.User;

public interface DemoService {

    String sayHello(String name);

    public List<User> getUsers();

}
