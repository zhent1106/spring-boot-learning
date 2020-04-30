package com.soft1851.springboot.verification.util;

import com.soft1851.springboot.verification.annotaction.Region;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * @ClassName ConstraintValidator
 * @Description 自定义校验规则
 * @Author 田震
 * @Date 2020/4/30
 **/
public class RegionValidator implements ConstraintValidator<Region,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HashSet<Object> regions=new HashSet<>();
        regions.add("China");
        regions.add("China-Taiwan");
        regions.add("China-HongKong");
        return regions.contains(s);
    }
}