package com.example.textcomparer.service;

import java.util.List;

import com.example.textcomparer.entity.TextValue;
import com.example.textcomparer.entity.TextValueHistory;
import com.example.textcomparer.mappers.TextValueHistoryMapper;
import com.example.textcomparer.mappers.TextValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextValueServiceImpl implements TextValueService {

  @Autowired
  private TextValueMapper textValueMapper;

  @Autowired
  private TextValueHistoryMapper textValueHistoryMapper;

  //TODO: implement paging
  @Override
  public List<TextValue> getTextValues() {
    return textValueMapper.findAllTextValues();
  }

  @Override
  public TextValue getTextValue(Long id) {
    return textValueMapper.findTextValueById(id);
  }

  //TODO: implement paging
  @Override
  public List<TextValueHistory> getTextValueHistories(Long textValueId) {
    return textValueHistoryMapper.findAllTextValueHistories(textValueId);
  }

  @Override
  public TextValueHistory getTextValueHistory(Long textValueHistoryId) {
    return textValueHistoryMapper.findTextValueHistoryById(textValueHistoryId);
  }

  @Override
  public TextValue createTextValue(TextValue textValue) {
    textValueMapper.insertTextValue(textValue);
    textValue = textValueMapper.findTextValueById(textValue.getId());
    textValueHistoryMapper.createTextValueHistory(textValue);
    return textValue;
  }

  @Override
  public TextValue updateTextValue(TextValue textValue) {
    textValueMapper.updateTextValue(textValue);
    textValue = textValueMapper.findTextValueById(textValue.getId());
    textValueHistoryMapper.createTextValueHistory(textValue);
    return textValue;
  }

  @Override
  public void deleteTextValue(Long textValueId) {
    textValueHistoryMapper.deleteTextValueAllHistory(textValueId);
    textValueMapper.deleteTextValue(textValueId);
  }
}
