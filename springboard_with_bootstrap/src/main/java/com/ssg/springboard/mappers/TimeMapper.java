package com.ssg.springboard.mappers;

import org.apache.ibatis.annotations.Insert;

public interface TimeMapper {

  @Insert("insert into transaction_test1 (col) values (#{str})")
  int insert1(String str);


  @Insert("insert into transaction_test2 (col) values (#{str})")
  int insert2(String str);




}
