package com.ssg.todoservice.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TodoDTO {

  private Long tno;
  @NotBlank
  private String title;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dueDate;

  @NotBlank
  private String writer;
  private boolean finished;

}
