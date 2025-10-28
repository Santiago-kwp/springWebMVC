package com.ssg.membertest.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;
  private String writer;

}
