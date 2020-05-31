package com.luyuze.missyou.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {

    @GetMapping("/hello")
    public String test() {
        return "Hello, 宇泽111";
    }
}
