package com.luyuze.missyou.service;

import com.luyuze.missyou.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    Map<Integer, List<Category>> getAll();
}
