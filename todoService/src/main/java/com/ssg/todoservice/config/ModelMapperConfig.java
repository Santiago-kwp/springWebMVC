package com.ssg.todoservice.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 해당 클래스가 스프링 빈에 대한 설정을 하는 클래스임을 표기 및 스프링 빈에 등록
public class ModelMapperConfig {

  @Bean // 해당 메소드의 실행 결과로 반환된 객체를 스프링의 빈으로 등록하는 역할
  public ModelMapper get() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true) // 필드 이름 기반 매핑 활성화 (getter/setter 없이도 매핑 가능)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) // private 필드 접근 허용 (리플렉션 기반)
        .setMatchingStrategy(MatchingStrategies.LOOSE) // 이름이 비슷하면 매핑 시도 (실수 유발 가능)
        .setAmbiguityIgnored(true) // 모호한 매핑 무시 (매핑 충돌 시 예외 방지)
        .setSkipNullEnabled(true); // null 값은 매핑에서 제외 (기존 값 유지)
    return modelMapper;
  }
}
