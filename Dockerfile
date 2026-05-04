# 1. 자바 17 버전 환경을 가져옵니다.
FROM eclipse-temurin:17-jdk-alpine

# 2. 빌드된 결과물(jar)을 컨테이너 안으로 app.jar라는 이름으로 복사합니다.
# Gradle 빌드 시 생성되는 위치입니다.
COPY build/libs/*-SNAPSHOT.jar app.jar

# 3. 컨테이너가 켜질 때 자바 실행 명령어를 입력합니다.
ENTRYPOINT ["java", "-jar", "/app.jar"]