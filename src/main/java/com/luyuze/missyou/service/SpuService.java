package com.luyuze.missyou.service;

import com.luyuze.missyou.model.Spu;
import org.springframework.data.domain.Page;


public interface SpuService {
    Spu getSpu(Long id);

    Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);
}
