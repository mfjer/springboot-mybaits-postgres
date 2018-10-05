package com.jksc.jkscapp.handler;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.jksc.jkscapp.utils.JsonUtil;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@MappedTypes({Object.class})
public class JsonTypeHandler extends BaseTypeHandler <Object> {

    private static final PGobject jsonObject = new PGobject();
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        jsonObject.setType("json");
        jsonObject.setValue(JSON.toJSONString(o));
        preparedStatement.setObject(i,jsonObject);

    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return JsonUtil.jsonToBean(resultSet.getString(s),PGobject.class);
    	
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return JsonUtil.jsonToBean(resultSet.getString(i),PGobject.class);
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return JsonUtil.jsonToBean(callableStatement.getString(i),PGobject.class);
    }
}