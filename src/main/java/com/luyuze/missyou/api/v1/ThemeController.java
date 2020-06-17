package com.luyuze.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.luyuze.missyou.exception.http.NotFoundException;
import com.luyuze.missyou.model.Theme;
import com.luyuze.missyou.service.ThemeService;
import com.luyuze.missyou.vo.ThemePureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theme")
@Validated
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/by/names")
    public List<ThemePureVO> getThemeGroupByNames(
            @RequestParam(name = "names") String names
    ) {
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.findByNames(nameList);
        List<ThemePureVO> list = new ArrayList<>();
        themes.forEach(t -> {
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            ThemePureVO vo = mapper.map(t, ThemePureVO.class);
            list.add(vo);
        });
        return list;
    }

    @GetMapping("/name/{name}/with_spu")
    public Theme getThemeByNameWithSpu(
            @PathVariable(name = "name") String name
    ) {
        Optional<Theme> optionalTheme = themeService.findByName(name);
        return optionalTheme.orElseThrow(() -> new NotFoundException(30003));
    }
}
