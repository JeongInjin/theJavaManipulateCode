#JDK

#JVM 구조
- 클래스로더
- 메모리
- 실행 엔진
- JNI + 네이티브 메소드 라이브러리

#바이트 코드 조작 - 테스트 커버리지
- 테스트 커버리지 라이브러리
  - jacoco
- 바이트코드 조작 라이브러리
  - ByteBuddy - 추천 (활용방법 정도 찾아보면 신기할듯)
  - ASM (비추천)
  - Javassist (비추천)

#리플렉션
- 스프링 Dependency Injection
- Class<T> 리플렉션 API
- 애노테이션과 리플렉션
  - value 기본값, 상속 Inherited, annotation 의 정보를 가져와 비교
- 클래스 정보 수정
  - 