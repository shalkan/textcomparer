package com.example.textcomparer.mappers;

import java.util.List;

import com.example.textcomparer.entity.TextValue;
import org.apache.ibatis.annotations.*;

public interface TextValueMapper {

  @Insert("insert into text_value_table(text_value) values(#{textValue})")
//  @SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=Long.class)
  Long insertTextValue(TextValue textValue);

  @Insert("update text_value_table set text_value = #{textValue}, aud_when = now()where id=#{id}")
  Long updateTextValue(TextValue textValue);

  @Select("select id, text_value, aud_when, aud_when_create from text_value_table WHERE id=#{id}")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "textValue", column = "text_value"),
      @Result(property = "audWhen", column = "aud_when"),
      @Result(property = "audWhenCreate", column = "aud_when_create")
  })
  TextValue findTextValueById(Long id);

  @Select("select id, text_value, aud_when, aud_when_create from text_value_table order by aud_when desc")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "textValue", column = "text_value"),
      @Result(property = "audWhen", column = "aud_when"),
      @Result(property = "audWhenCreate", column = "aud_when_create")
  })
  List<TextValue> findAllTextValues();

  @Delete("delete from text_value_table where id=#{id}")
  void deleteTextValue(Long id);
}
