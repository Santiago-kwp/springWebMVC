package com.ssg.springboard.service;

import com.ssg.springboard.mappers.TimeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Log4j2
@Service
public class TimeService {

  private final TimeMapper timeMapper;

  public void insertTwo(String str) {

    timeMapper.insert1(str);
    timeMapper.insert2(str);

  }


}
