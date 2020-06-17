package com.luyuze.missyou.service.impl;

import com.luyuze.missyou.model.Theme;
import com.luyuze.missyou.repository.ThemeRepository;
import com.luyuze.missyou.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public List<Theme> findByNames(List<String> names) {
        return themeRepository.findByNames(names);
    }

    @Override
    public Optional<Theme> findByName(String name) {
        return Optional.empty();
    }
}
