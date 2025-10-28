package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor
public class Restaurant {
  // 레스토랑은 쉐프를 가지고 있어야 한다.
  private final Chef chef;

  @Override public String toString() {
    return "Restaruant(Chef=" + AopUtils.getTargetClass(chef).getName() +")";
  }

}
