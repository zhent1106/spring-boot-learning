package com.soft1851.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhent
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;

    /**
     * 父类id
     */
    private Integer parentId;

    /**
     * 权限名称
     */
    private String pName;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 地址
     */
    private String path;

    /**
     * 扩展字段1
     */
    private String ex1;

    /**
     * 扩展字段2
     */
    private Integer ex2;


}
