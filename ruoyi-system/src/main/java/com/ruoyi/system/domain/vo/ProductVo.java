package com.ruoyi.system.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductVo {

    @TableId(type = IdType.AUTO)
    private String ID;

    private String buyList;

    private String productId;

    private String assetType;


    private String productCode;


    private String MAKER;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date modDatetime;


    private String CHECKER;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date chckerDatetime;

    private String STATUS;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
