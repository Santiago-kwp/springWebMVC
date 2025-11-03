package com.ssg.springboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReplyVO {
  private Long rno;
  private Long bno;

  private String replyText;
  private String replyer;

  @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
  private LocalDateTime regDate;

  @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
  private LocalDateTime updateDate;



}
