package com.luyuze.missyou.dto;

import com.luyuze.missyou.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;


@Builder
@Getter
@PasswordEqual
public class PersonDTO {

    @Length(min = 2, max = 10, message = "长度只能在2到10")
    private String name;

    private Integer age;

    private String password1;

    private String password2;
}
