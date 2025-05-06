package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Excel(name = "ID", readConverterExp = "ID")
    private String ID;

    /** $column.columnComment */
    @Excel(name = "buyList", readConverterExp = "buyList")
    private String buyList;

    /** $column.columnComment */
    @Excel(name = "status", readConverterExp = "status")
    private String status;
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

    /** 采购清单信息 */
    @TableField(exist = false)
    private List<BuyList> buyListList;

    /** 请求参数 */
    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> params;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBuyList() {
        return buyList;
    }

    public void setBuyList(String buyList) {
        this.buyList = buyList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMAKER() {
        return MAKER;
    }

    public void setMAKER(String MAKER) {
        this.MAKER = MAKER;
    }

    public Date getModDatetime() {
        return modDatetime;
    }

    public void setModDatetime(Date modDatetime) {
        this.modDatetime = modDatetime;
    }

    public String getCHECKER() {
        return CHECKER;
    }

    public void setCHECKER(String CHECKER) {
        this.CHECKER = CHECKER;
    }

    public Date getChckerDatetime() {
        return chckerDatetime;
    }

    public void setChckerDatetime(Date chckerDatetime) {
        this.chckerDatetime = chckerDatetime;
    }
}
