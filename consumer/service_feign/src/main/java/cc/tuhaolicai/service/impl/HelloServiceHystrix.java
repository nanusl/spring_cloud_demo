package cc.tuhaolicai.service.impl;

import cc.tuhaolicai.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title： HelloServiceHystric
 * @Package： cc.tuhaolicai.service.impl
 * @Description： 供熔断器回调
 * @author： nan
 * @date： 2017-06-16 9:57
 */
@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String sayHi(String name) {
        return "sorry " + name;
    }
}
