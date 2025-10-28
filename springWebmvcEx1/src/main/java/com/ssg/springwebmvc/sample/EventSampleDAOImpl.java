package com.ssg.springwebmvc.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository // 2개가 중복되서 충돌남
//@Primary => 우선순위 지정
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO{

}
