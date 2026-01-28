package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {
    @Select("SELECT COUNT(*) FROM dish WHERE category_id = #{id}")
    int countByCategoryId(Long id);
}
