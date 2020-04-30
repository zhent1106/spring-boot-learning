package com.soft1851.springboot.verification.controller;

import com.soft1851.springboot.verification.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @ClassName PersonController
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/30
 **/
@RestController
@RequestMapping("/api")
@Slf4j
@Validated
public class PersonController {

    /**
     * 在需要验证的参数上加@Valid注解，如果验证失败，它将抛出MethodArgumentNotValidException。默认情况下，Spring会将此异常转换为HTTP Status 400（错误请求）。
     * @param person
     * @return
     */
    @PostMapping("/person")
    public ResponseEntity<Person> getPerson(@RequestBody @Valid Person person) {
log.info("入参对象："+person);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/person/{id}")
    public  ResponseEntity<Integer> getPersonById(@Valid @PathVariable("id") @Size(min=6,message = "id不能小于6位") String id){
        return  ResponseEntity.ok().body(Integer.parseInt(id));
    }
    @PutMapping("/person")
    public  ResponseEntity<String> getPersonByName(@Valid @RequestParam("name") @Size(max = 10,
            message = "name长度超出范围") String name){
        return ResponseEntity.ok().body(name);
    }
}