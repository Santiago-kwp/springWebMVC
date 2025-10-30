package com.ssg.boardservice.config;
import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.dto.BoardRegisterDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//LOOSE는 편하지만 예외가 생길 수 있어 (특히 setter 없는 객체에서)
// STRICT는 이름이 정확히 일치해야 하므로 안정적이고 예측 가능



@Configuration // 해당 클래스가 스프링 빈에 대한 설정을 하는 클래스임을 표기 및 스프링 빈에 등록
public class ModelMapperConfig {

  @Bean
  public ModelMapper get() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        .setMatchingStrategy(MatchingStrategies.STRICT) // STRICT로 변경하여 정확한 매핑을 유도 -> LOOSE로 했더니 bId 안불러옴..?
        .setAmbiguityIgnored(true)
        .setSkipNullEnabled(true);
    return modelMapper;
  }
}
