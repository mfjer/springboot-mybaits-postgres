package com.jksc.jkscapp.domain;

import java.util.Date;

import org.postgresql.util.PGobject;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author liaodg
 *
 */
public class TbProductAttr {
	
    private String id;

    private String name;

    private PGobject attribute;
    
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public PGobject getAttribute() {
        return attribute;
    }

    public void setAttribute(PGobject attribute) {
        this.attribute = attribute;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}