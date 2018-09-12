package com.example.textcomparer.service;

import java.util.List;

import com.example.textcomparer.entity.TextValue;
import com.example.textcomparer.entity.TextValueHistory;


public interface TextValueService {

  List<TextValue> getTextValues();

  TextValue getTextValue(Long id);

  List<TextValueHistory> getTextValueHistories(Long textValueId);

  TextValueHistory getTextValueHistory(Long textValueHistoryId);

  TextValue createTextValue(TextValue textValue);

  TextValue updateTextValue(TextValue textValue);

  void deleteTextValue(Long textValueId);
}
