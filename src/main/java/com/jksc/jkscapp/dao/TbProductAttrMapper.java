package com.jksc.jkscapp.dao;

import org.apache.ibatis.annotations.Param;

import com.jksc.jkscapp.domain.TbProductAttr;

public interface TbProductAttrMapper {
    int insert(TbProductAttr record);

    int insertSelective(TbProductAttr record);
    
    int updateData(TbProductAttr record);
    
    TbProductAttr findById(@Param("id") String id);
}