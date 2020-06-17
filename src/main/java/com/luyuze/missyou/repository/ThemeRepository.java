package com.luyuze.missyou.repository;

import com.luyuze.missyou.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Query("select t from Theme t where t.name in (:names)")
    List<Theme> findByNames(@Param("names") List<String> names);

    Optional<Theme> findByName(String name);
}
