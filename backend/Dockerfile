# backend/Dockerfile 내용 예시
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# 빌드된 jar 파일을 컨테이너의 app.jar로 복사
COPY build/libs/*.jar app.jar
# 스프링 부트 기본 포트 노출
EXPOSE 8080
# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]