package com.luyuze.missyou.api.v1;

import com.luyuze.missyou.vo.CategoriesAllVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
@Validated
public class CategoryController {

    @GetMapping("/all")
    public CategoriesAllVO getAll() {
        return null;
    }
}
