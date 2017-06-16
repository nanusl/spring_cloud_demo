package cc.tuhaolicai.service;

import cc.tuhaolicai.service.impl.HelloServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version V1.0
 * @Title： HelloService
 * @Package： cc.tuhaolicai.service
 * @Description： HelloService接口
 * @author： nan
 * @date： 2017-06-15 14:45
 */
@FeignClient(value = "service-hi", fallback = HelloServiceHystrix.class)
public interface HelloService {
    /**
     * say hi
     *
     * @param name 姓名
     * @return
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "name") String name);
}
