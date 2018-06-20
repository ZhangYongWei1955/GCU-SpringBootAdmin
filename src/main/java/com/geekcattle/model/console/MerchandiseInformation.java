package com.geekcattle.model.console;

import javax.persistence.*;

@Table(name = "merchandise_information")
public class MerchandiseInformation {
    /**
     * 商品
     */
    @Id
    @Column(name = "merchandise_id")
    @GeneratedValue(generator = "UUID")
    private String merchandiseId;

    /**
     * 商品名称
     */
    @Column(name = "merchandise_name")
    private String merchandiseName;

    /**
     * 商品价钱
     */
    @Column(name = "merchandise_price")
    private Integer merchandisePrice;

       /**
     * 创建时间
     */
    @Column(name = "merchandise_created_time")
    private String merchandiseCreatedTime;

    /**
     * 更新时间
     */
    @Column(name = "merchandise_updated_time")
    private String merchandiseUpdatedTime;

    /**
     * 获取商品
     *
     * @return merchandise_id - 商品
     */
    public String getMerchandiseId() {
        return merchandiseId;
    }

    /**
     * 设置商品
     *
     * @param merchandiseId 商品
     */
    public void setMerchandiseId(String merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    /**
     * 获取商品名称
     *
     * @return merchandise_name - 商品名称
     */
    public String getMerchandiseName() {
        return merchandiseName;
    }

    /**
     * 设置商品名称
     *
     * @param merchandiseName 商品名称
     */
    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }

    /**
     * 获取商品价钱
     *
     * @return merchandise_price - 商品价钱
     */
    public Integer getMerchandisePrice() {
        return merchandisePrice;
    }

    /**
     * 设置商品价钱
     *
     * @param merchandisePrice 商品价钱
     */
    public void setMerchandisePrice(Integer merchandisePrice) {
        this.merchandisePrice = merchandisePrice;
    }

    /**
     * 获取创建时间
     *
     * @return merchandise_created_time - 创建时间
     */
    public String getMerchandiseCreatedTime() {
        return merchandiseCreatedTime;
    }

    /**
     * 设置创建时间
     *
     * @param merchandiseCreatedTime 创建时间
     */
    public void setMerchandiseCreateTime(String merchandiseCreatedTime) {
        this.merchandiseCreatedTime = merchandiseCreatedTime;
    }

    /**
     * 获取更新时间
     *
     * @return merchandise_updated_time - 更新时间
     */
    public String getMerchandiseUpdatedTime() {
        return merchandiseUpdatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param merchandiseUpdatedTime 更新时间
     */
    public void setMerchandiseUpdatedTime(String merchandiseUpdatedTime) {
        this.merchandiseUpdatedTime = merchandiseUpdatedTime;
    }

}