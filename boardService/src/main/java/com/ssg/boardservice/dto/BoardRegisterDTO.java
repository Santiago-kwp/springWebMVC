package com.ssg.boardservice.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardRegisterDTO {
  @NotBlank(message = "제목은 필수 입력 사항입니다.")
  private String title;

  @NotBlank(message = "작성자는 필수 입력 사항입니다.")
  private String writer;

  private String content;

  @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
  private String password;

  private String userId;

  private MultipartFile file; // 파일 업로드를 위한 필드
}
