package com.luyuze.missyou.api.v1;

import com.luyuze.missyou.dto.PersonDTO;
import com.luyuze.missyou.exception.http.HttpException;
import com.luyuze.missyou.exception.http.NotFoundException;
import com.luyuze.missyou.model.Banner;
import com.luyuze.missyou.service.BannerService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public Banner getByName(@PathVariable @NotBlank String name) {
        Banner banner = bannerService.getByName(name);
        return banner;
    }

    @GetMapping("/hello")
    public String test(
//            @PathVariable @Range(min = 1, max = 10, message = "只能1到10哦") Integer id, // url路径参数
//            @RequestParam String name, // url查询参数
//            @RequestBody @Validated PersonDTO person // 请求体参数
    ) throws Exception {
        throw new NotFoundException(10001);
    }
}
