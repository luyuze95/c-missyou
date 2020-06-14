package com.luyuze.missyou.util;

import com.luyuze.missyou.bo.PageCounter;

public class CommonUtil {

    public static PageCounter convertToPageParameter(Integer start, Integer count) {
        int pageNum = start / count;
        return PageCounter.builder()
                .page(pageNum)
                .count(count)
                .build();
    }
}
