package com.ssg.boardservice.domain;


import java.time.LocalDateTime;import lombok.AllArgsConstructor;import lombok.Builder;import lombok.Getter;import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
  private Long bno;
  private String title;
  private String writer;
  private String content;
  private String password;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private Long hits;
  private String filePath;
  private String originalFileName;
  private String userId;
}


