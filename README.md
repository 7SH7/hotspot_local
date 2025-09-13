# hotspot_local

## 1. 프로젝트 개요 (Overview)

*   **프로젝트 이름:** hotspot_local
*   **한 줄 요약:** 내 입맛에 딱 맞는 매운 음식점을 찾아주는 위치 기반 맛집 추천 서비스
*   **프로젝트 설명:** "신라면 정도 맵기"와 같은 부정확한 맵기 정보에 지치셨나요? `hotspot_local`은 사용자의 실제 리뷰를 바탕으로 음식점의 '불점'을 매겨, 개인의 매운맛 선호도에 맞는 음식점을 찾아주는 서비스입니다. 더 이상 맵기 선택에 실패하지 마세요.

## 2. 주요 기능 (Features)

*   **위치 기반 음식점 검색:** 카카오맵 API를 활용하여 사용자 주변의 음식점을 검색합니다.
*   **'불점' 시스템:** 사용자들이 직접 평가한 맵기 점수인 '불점'을 통해 음식점의 실제 맵기 수준을 확인하고, 내 입맛에 맞는 곳을 찾을 수 있습니다.
*   **매운맛 취향 분석:** 간단한 설문을 통해 사용자의 매운맛 취향을 파악하고, 그에 맞는 캐릭터를 부여하여 재미를 더했습니다.
*   **리뷰 및 평점:** 음식점에 대한 리뷰와 '불점'을 남기고 다른 사용자들과 공유할 수 있습니다.
*   **소셜 로그인:** Google OAuth2를 통해 간편하게 로그인하고 서비스를 이용할 수 있습니다.
*   **마이페이지:** 내가 작성한 리뷰를 확인하고, 내 매운맛 취향 캐릭터를 볼 수 있습니다.
*   **이미지 업로드:** 리뷰 작성 시 AWS S3를 통해 이미지를 업로드하여 더 생생한 후기를 전달할 수 있습니다.

## 3. 설치 및 실행 방법 (Installation & Usage)

### 최소 요구사항

*   Java 17
*   Gradle 7.0 이상

### 설치 및 실행

1.  **프로젝트 클론:**
    ```bash
    git clone https://github.com/your-username/hotspot_local.git
    cd hotspot_local
    ```

2.  **환경 변수 설정:**
    `src/main/resources/application.properties` 또는 환경 변수를 통해 아래 정보들을 설정해야 합니다.
    *   **Database (MySQL):** DB URL, username, password
    *   **Google OAuth2:** Client ID, Client Secret
    *   **Kakao Maps API:** API Key
    *   **AWS S3:** Access Key, Secret Key, Bucket Name

3.  **프로젝트 빌드 및 실행:**
    ```bash
    ./gradlew build
    java -jar build/libs/hotspot_local-0.0.1-SNAPSHOT.jar
    ```
    이제 `http://localhost:8080`에서 애플리케이션이 실행됩니다.

## 4. 아키텍처 & 기술 스택 (Architecture & Tech Stack)

### 기술 스택

*   **언어:** Java 17
*   **프레임워크:** Spring Boot 3.2.5, Spring Security, Spring Data JPA
*   **데이터베이스:** MySQL (운영), H2 (테스트)
*   **캐싱:** Caffeine
*   **외부 연동 서비스:**
    *   Google OAuth2 (인증)
    *   Kakao Maps API (지도 및 장소 검색)
    *   AWS S3 (이미지 저장소)
*   **라이브러리:** Lombok, WebFlux/Reactor (비동기 API 호출)

### 시스템 아키텍처

```
+-----------------+      +---------------------+      +--------------------+
|                 |      |                     |      |                    |
|      User       |<---->| hotspot_local (API) |<---->|      Database      |
| (Web/Mobile App)|      |   (Spring Boot)     |      |      (MySQL)       |
|                 |      |                     |      |                    |
+-----------------+      +---------+-----------+      +--------------------+
                                   |
                                   |
           +-----------------------+-----------------------+
           |                       |                       |
+----------v-----------+ +---------v-----------+ +---------v-----------+
|                      | |                     | |                     |
|   Google OAuth2      | |   Kakao Maps API    | |       AWS S3        |
|      (Login)         | |      (Search)       | |   (Image Storage)   |
|                      | |                     | |                     |
+----------------------+ +---------------------+ +---------------------+
```

*   **Client (Web/Mobile):** 사용자 인터페이스를 제공하고 `hotspot_local` API 서버와 통신합니다.
*   **API Server (Spring Boot):** 핵심 비즈니스 로직을 처리합니다. 외부 서비스(Google, Kakao, AWS)와 연동하고, 데이터베이스에 정보를 저장/조회합니다.
*   **Database (MySQL):** 사용자 정보, 가게 정보, 리뷰, '불점' 등 데이터를 영구적으로 저장합니다.
*   **External Services:** 인증, 지도/장소 정보, 이미지 저장을 위해 외부 API를 활용합니다.