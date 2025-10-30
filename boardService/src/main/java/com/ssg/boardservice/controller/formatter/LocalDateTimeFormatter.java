package com.ssg.boardservice.controller.formatter;

import org.springframework.format.Formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.text.ParseException;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public LocalDateTime parse(String text, Locale locale) throws ParseException {
    return LocalDateTime.parse(text, FORMATTER);
  }

  @Override
  public String print(LocalDateTime object, Locale locale) {
    return FORMATTER.format(object);
  }
}
