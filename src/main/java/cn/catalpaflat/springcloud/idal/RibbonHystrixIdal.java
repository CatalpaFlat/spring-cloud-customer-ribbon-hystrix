package cn.catalpaflat.springcloud.idal;

import cn.catalpaflat.springcloud.model.User;
import cn.catalpaflat.springcloud.service.RibbonHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CatalpaFlat
 * @date Created in 2018/4/7 下午5:09
 */
@RestController
public class RibbonHystrixIdal {
    @Resource
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("ribbon/{uuid}")
    public User obtainUser(@PathVariable String uuid) {
        return ribbonHystrixService.obtainUser(uuid);
    }
}
