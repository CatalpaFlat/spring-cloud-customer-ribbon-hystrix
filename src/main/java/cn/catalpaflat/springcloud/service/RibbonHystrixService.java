package cn.catalpaflat.springcloud.service;

import cn.catalpaflat.springcloud.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author CatalpaFlat
 * @date Created in 2018/4/7 下午7:00
 */
@Service
public class RibbonHystrixService {
    @Resource
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     *
     * @param uuid uuid
     * @return 通过id查询到的用户
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User obtainUser(String uuid) {
        return this.restTemplate.getForObject("http://spring-cloud-provider-demo/" + uuid, User.class);
    }

    /**
     * hystrix fallback方法
     *
     * @param uuid id
     * @return 默认的用户
     */
    public User fallback(String uuid) {
        RibbonHystrixService.LOGGER.info("异常发生，进入fallback方法，接收的参数：uuid = {}", uuid);
        User user = new User();
        user.setUuid(uuid);
        user.setName("default username");
        user.setMobile("18475525881");
        return user;
    }
}
