package cc.tuhaolicai.controller;

import cc.tuhaolicai.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @Title： HelloController
 * @Package： cc.tuhaolicai.controller
 * @Description： HelloController
 * @author： nan
 * @date： 2017-06-15 14:52
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.sayHi(name);
    }
}
