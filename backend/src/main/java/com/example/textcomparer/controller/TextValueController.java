package com.example.textcomparer.controller;

import java.util.Collections;
import java.util.List;

import com.example.textcomparer.entity.TextValue;
import com.example.textcomparer.entity.TextValueHistory;
import com.example.textcomparer.service.TextValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text-value")
public class TextValueController {

  @Autowired
  private TextValueService textValueService;

  @GetMapping
  public List<TextValue> getTextValues( ) {
    return textValueService.getTextValues();
  }

  @PostMapping
  public TextValue createTextValue(@RequestBody TextValue textValue) {
    return textValueService.createTextValue(textValue);
  }

  @PutMapping
  public TextValue updateTextValue(@RequestBody TextValue textValue) {
    return textValueService.updateTextValue(textValue);
  }

  @DeleteMapping
  public void deleteTextValue(@RequestParam Long id) {
    textValueService.deleteTextValue(id);
  }

  @GetMapping("/history")
  public List<TextValueHistory> getTextValueHistory(@RequestParam long textValueId) {
    return textValueService.getTextValueHistories(textValueId);
  }
}
