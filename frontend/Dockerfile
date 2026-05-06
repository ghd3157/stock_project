# 1단계: 빌드 환경 (Node.js)
FROM node:20-alpine as build-stage
WORKDIR /app
# 패키지 정보 복사 및 의존성 설치
COPY package*.json ./
RUN npm install
# 소스 코드 복사 및 빌드 (Vite 빌드 결과물은 dist 폴더에 생성됨)
COPY . .
RUN npm run build

# 2단계: 실행 환경 (Nginx 웹 서버)
FROM nginx:alpine as production-stage
# 1단계에서 빌드된 결과물(dist)을 Nginx의 기본 서비스 폴더로 복사
COPY --from=build-stage /app/dist /usr/share/nginx/html
# SPA(React) 라우팅 처리를 위해 80번 포트 개방
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]