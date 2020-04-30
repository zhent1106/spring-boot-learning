package com.soft1851.springboot.verification.service;

import com.soft1851.springboot.verification.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.validation.*;
import java.util.Set;

@SpringBootTest
class PersonServiceTest {
@Resource
private  PersonService personService;
    @Test
    @ExceptionHandler({ConstraintViolationException.class})
    void validatePerson() {

        Person person=new Person();
        person.setId("1802343315");
        person.setName("zhent");
        person.setAge(20);
        person.setPhone("15035897885");
        person.setEmail("zhent1106@163.com");
        person.setSex("Man");
        personService.validatePerson(person);

    }

    /**
     * 手动检验参数
     */
    @Test
    void  checkManually(){
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Validator validator=factory.getValidator();
        Person person=new Person();
        person.setId("15");
        person.setEmail("zhent1106@163.com");
        person.setSex("Man1");
        person.setPhone("15035897885");
        person.setRegion("China");
        Set<ConstraintViolation<Person> > violations=validator.validate(person);
        for (ConstraintViolation<Person> constraintViolation:violations){
            System.out.println(constraintViolation.getMessage());
        }

    }
}