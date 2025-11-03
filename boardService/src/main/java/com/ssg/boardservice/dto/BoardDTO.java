package com.ssg.boardservice.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotBlank;import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class BoardDTO {

  private Long bno;

  @NotBlank
  private String title;

  @NotBlank
  private String writer;

  private String content;

  @NotBlank
  private String password;

  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private Long hits;

  private String userId;
  private String filePath;          // 파일 경로 (조회 시 사용, 등록/수정 시 직접 설정)
  private String originalFileName;  // 원본 파일명 (조회 시 사용, 등록/수정 시 직접 설정)


  public String getRegStr(){
    return createdDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

  public String getUpdateStr(){

    return updatedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

  }
}