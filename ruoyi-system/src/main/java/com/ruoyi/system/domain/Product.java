package com.ruoyi.system.domain;

import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 清单列表对象 product
 * 
 * @author admin
 * @date 2025-04-24
 */
@Data
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ID;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String buyList;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String buyListID;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    /** 采购清单信息 */
    @TableField(exist = false)
    private List<BuyList> buyListList;

    /** 请求参数 */
    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> params;
}
