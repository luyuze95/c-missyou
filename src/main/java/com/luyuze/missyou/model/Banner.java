package com.luyuze.missyou.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16)
    private String name;

    @Transient
    private String description;

    private String img;

    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
