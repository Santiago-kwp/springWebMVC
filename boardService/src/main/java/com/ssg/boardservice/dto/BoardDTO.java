package com.ssg.boardservice.dto;

import java.time.LocalDateTime;import javax.validation.constraints.NotBlank;import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardDTO {

  private Long bId;

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

  public Long getBId() {
    return bId;
  }
}