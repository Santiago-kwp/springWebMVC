package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor // 생성자 주입 방식
public class SampleService {

  @Qualifier("event")
  private final SampleDAO sampleDAO;

}
