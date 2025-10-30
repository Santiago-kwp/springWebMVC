# Spring Web MVC 기반 BOARD CRUD
> 프로젝트 목적
- Spring WebMVC 구조 설계 및 설정 연습
- 게시판 CRUD 로직 구현 연습
- JSP, BootStrap5 를 통한 웹 페이지 구현 연습

## 📦기술 스택
- Java 8
- Spring Web MVC
- MyBatis
- JSP
- Bootstrap 5
- Log4j2
- Lombok
- Gradle

## 📁프로젝트 구조
```
src/main/java/com/ssg/boardservice/
├── config/
│   └── ModelMapperConfig.java # 설정 클래스 (예: ModelMapper 설정)
├── controller/
│   ├── BoardController.java   # 컨트롤러 계층
│   └── formatter/             # 사용자 입력 포맷터
│       ├── CheckboxFormatter.java
│       └── LocalDateFormatter.java
├── domain/                    # 도메인 객체 (Getter only)
│   └── BoardVO.java
├── dto/                       # 데이터 전송 객체 (계층간 데이터 전송목적)
│   └── BoardDTO.java
├── mapper/                    # MyBatis 매퍼 인터페이스
│   └── BoardMapper.java
├── service/                   # 서비스 계층
│   ├── BoardService.java  
│   └── BoardServiceImpl.java
└── lombok.config              # Lombok 설정 파일


src/main/resources/
├── log4j2.xml                 # 로깅 설정
├── mappers/                   # MyBatis XML 매퍼
│   └── BoardMapper.xml
└── static/                    # 정적 리소스

src/main/webapp/
└── WEB-INF/
    ├── web.xml                # 웹 애플리케이션 설정
    ├── spring/                # Spring 설정 파일
    │   ├── root-context.xml
    │   └── servlet-context.xml
    └── views/                 # JSP 뷰
        ├── custom404.jsp
        ├── custom500.jsp
        └── board/
            ├── list.jsp
            ├── modify.jsp
            ├── read.jsp
            └── register.jsp

src/test/                      # 단위 테스트
├── java/com/ssg/boardservice/mapper/
│   └── MapperTests.java      
└── resources/
```

## 📌주요 기능
- ✅ Board 목록 조회
- ✅ Board 등록
- ✅ Board 상세 조회
- ✅ Board 수정
- ✅ Board 삭제