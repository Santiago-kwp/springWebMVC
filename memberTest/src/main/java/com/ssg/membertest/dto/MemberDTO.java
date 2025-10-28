package com.ssg.membertest.dto;


import lombok.Data;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberDTO {

  @NotBlank
  private String mid;

  @NotBlank
  private String mpw;

  @NotBlank
  private String mname;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate joinDate;

}