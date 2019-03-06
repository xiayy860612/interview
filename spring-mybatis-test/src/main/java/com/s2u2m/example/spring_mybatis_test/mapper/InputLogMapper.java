package com.s2u2m.example.spring_mybatis_test.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InputLogMapper {

    @Insert("insert into input-log \n" +
            "(id, createTime, content) \n" +
            "values \n" +
            "(#{entity.id}, #{entity.createTime}, #{entity.content})")
    int insert(@Param("entity") InputLogEntity entity);
}
