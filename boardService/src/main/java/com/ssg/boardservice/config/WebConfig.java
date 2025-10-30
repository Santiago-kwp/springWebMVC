package com.ssg.boardservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {

  // Java Config 파일 (예: WebConfig.java)

  @Bean
  public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    // 최대 업로드 크기 등 설정 가능
    // multipartResolver.setMaxUploadSize(10485760); // 10MB
    return multipartResolver;
  }

}
