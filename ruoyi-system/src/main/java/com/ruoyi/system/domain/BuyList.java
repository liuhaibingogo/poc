package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 采购清单对象 buyList
 * 
 * @author admin
 * @date 2025-04-24
 */
@Data
public class BuyList implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @TableId(type = IdType.AUTO)
    private String ID;

    private String productId;

    /** $column.columnComment */
    @Excel(name = "assetType", readConverterExp = "assetType")
    private String assetType;

    /** $column.columnComment */
    @Excel(name = "productCode", readConverterExp = "productCode")
    private String productCode;

    /** $column.columnComment */
    @Excel(name = "MAKER", readConverterExp = "MAKER")
    private String MAKER;

    /** $column.columnComment */
    @Excel(name = "modDatetime", readConverterExp = "modDatetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modDatetime;

    /** $column.columnComment */
    @Excel(name = "CHECKER", readConverterExp = "CHECKER")
    private String CHECKER;

    /** $column.columnComment */
    @Excel(name = "chckerDatetime", readConverterExp = "chckerDatetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chckerDatetime;

    /** $column.columnComment */
    @Excel(name = "STATUS", readConverterExp = "STATUS")
    private String STATUS;

}
