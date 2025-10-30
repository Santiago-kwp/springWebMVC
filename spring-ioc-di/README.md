
# Spring IoC/DI Template (Java17, com.ssg.ioc)

Gradle 기반 스프링 IoC/DI 실습 템플릿입니다.  
`Repository → Service → Controller` 구조로 XML, @Configuration+@Bean, @ComponentScan 방식 모두 포함.

## 실행 방법

### 기본 (ComponentScan)
```bash
./gradlew run
```

### Bean 등록 방식
```bash
./gradlew run --args='bean'
```

### XML 설정 방식
```bash
./gradlew run --args='xml'
```

## JDK 17 환경
이 프로젝트는 `sourceCompatibility = 17`로 설정되어 있습니다.
