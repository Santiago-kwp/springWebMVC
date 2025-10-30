package com.ssg.boardservice.config;
import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.dto.BoardRegisterDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // 해당 클래스가 스프링 빈에 대한 설정을 하는 클래스임을 표기 및 스프링 빈에 등록
public class ModelMapperConfig {

  @Bean
  public ModelMapper get() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        .setMatchingStrategy(MatchingStrategies.LOOSE) // STRICT로 변경하여 정확한 매핑을 유도
        .setAmbiguityIgnored(true)
        .setSkipNullEnabled(true);
    return modelMapper;
  }
}
