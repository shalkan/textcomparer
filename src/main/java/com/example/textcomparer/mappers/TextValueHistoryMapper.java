package com.example.textcomparer.mappers;

import java.util.List;

import com.example.textcomparer.entity.TextValue;
import com.example.textcomparer.entity.TextValueHistory;
import org.apache.ibatis.annotations.*;

public interface TextValueHistoryMapper {

  @Insert("insert into text_value_history_table(when_edit, text_value_id, text_value) values(#{audWhen}, #{id}, #{textValue})")
  Long createTextValueHistory(TextValue textValue);

  @Select("select id, when_edit, text_value_id, text_value from text_value_history_table where text_value_id=#{textValueId}")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "whenEdit", column = "when_edit"),
      @Result(property = "textValueId", column = "text_value_id"),
      @Result(property = "textValue", column = "text_value")
  })
  List<TextValueHistory> findAllTextValueHistories(Long textValueId);

  @Select("select id, when_edit, text_value_id, text_value from text_value_history_table WHERE id=#{id}")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "whenEdit", column = "when_edit"),
      @Result(property = "textValueId", column = "text_value_id"),
      @Result(property = "textValue", column = "text_value")
  })
  TextValueHistory findTextValueHistoryById(Long id);

  @Delete("delete from text_value_history_table where text_value_id=#{textValueId}")
  void deleteTextValueAllHistory(Long textValueId);
}
