package com.luyuze.missyou.service.impl;

import com.luyuze.missyou.model.Banner;
import com.luyuze.missyou.repository.BannerRepository;
import com.luyuze.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner getByName(String name) {
        return bannerRepository.findOneByName(name);
    }
}
