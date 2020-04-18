package com.imooc.pojo;

public class Category {
    private Integer id;

    private String type;

    private Boolean hot;

    private Integer aid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return hot
     */
    public Boolean getHot() {
        return hot;
    }

    /**
     * @param hot
     */
    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    /**
     * @return aid
     */
    public Integer getAid() {
        return aid;
    }

    /**
     * @param aid
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }
}