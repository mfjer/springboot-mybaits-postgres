package com.jksc.jkscapp.web;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jksc.jkscapp.dao.TbProductAttrMapper;
import com.jksc.jkscapp.domain.TbProductAttr;

@Controller
public class ProductAttrController {
		
	@Autowired
	private TbProductAttrMapper attrDao;
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(){
		
		TbProductAttr record = new TbProductAttr();
		record.setId(UUID.randomUUID().toString());
		record.setName("water");
		record.setCreateTime(new Date());
		Map map = new HashMap<>();
		map.put("名称", "农夫山泉矿泉水");
		map.put("净含量", "1.5L");
		PGobject object = new PGobject();
		object.setType("json");
		try {
			object.setValue(JSON.toJSONString(map));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		record.setAttribute(object);

		int result = attrDao.insert(record);
		
		return result>0?"success!":"fail";
	}
	
	@ResponseBody
	@RequestMapping("/update/{id}")
	public TbProductAttr update(@PathVariable String id){
		TbProductAttr attr = attrDao.findById(id);
		try {
			Map map = JSON.parseObject(attr.getAttribute().getValue(), Map.class);
			map.put("保质期", "12月");
			attr.getAttribute().setValue(JSON.toJSONString(map));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int result = attrDao.updateData(attr);
		return result>0?attr:null;
	}
	
	@ResponseBody
	@RequestMapping("/{id}")
	public TbProductAttr get(@PathVariable String id){
		return attrDao.findById(id);
	
	}
}
