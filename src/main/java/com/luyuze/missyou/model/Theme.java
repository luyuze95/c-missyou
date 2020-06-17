package com.luyuze.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null")
public class Theme extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private String name;
    private String tplName;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Boolean online;

    @ManyToMany
    @JoinTable(name = "theme_spu", joinColumns = @JoinColumn(name = "theme_id"),
    inverseJoinColumns = @JoinColumn(name = "spu_id"))
    private List<Spu> spuList;


}
