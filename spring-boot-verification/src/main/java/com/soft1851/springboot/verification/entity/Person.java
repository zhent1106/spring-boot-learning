package com.soft1851.springboot.verification.entity;

import com.soft1851.springboot.verification.annotaction.PhoneNumber;
import com.soft1851.springboot.verification.annotaction.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @ClassName Person
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotNull(message = "Id不能为空")
    private  String id;
//    @Size(max = 30)
    @NotNull(message = "姓名不能为空")
    private  String name;
    @Min(18)
    private  Integer age;
//    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号格式错误")
    @PhoneNumber
    @NotBlank(message = "手机号不能为空")
    private  String phone;
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private  String email;
    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))",message = "性别值不在可选择范围内")
    @NotNull(message = "性别不能为空")
    private  String sex;
    @Region
    private String region;
}