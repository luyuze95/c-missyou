package com.luyuze.missyou.service.impl;

import com.luyuze.missyou.model.GridCategory;
import com.luyuze.missyou.repository.GridCategoryRepository;
import com.luyuze.missyou.service.GridCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryServiceImpl implements GridCategoryService {

    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    @Override
    public List<GridCategory> getGridCategoryList() {
        return gridCategoryRepository.findAll();
    }
}
