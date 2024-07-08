# 3학년 1학기 모바일 프로그래밍 팀 프로젝트
## 인하대후문 맛집 리뷰 등록 어플

<strong>👏🏻팀원👏🏻</strong><br>
인하공업전문대학 컴퓨터정보공학과 <a href="https://github.com/taegyeong0225">고태경 </a> <br>
인하공업전문대학 컴퓨터정보공학과 <a href="https://github.com/binbin7878">최경빈</a> <br><br>

<strong>⚒️TOOLS⚒️</strong><br>
Tools: ANDROID STUDIO Iguana 2023.02.01<br><br>

<strong>📱 LANGUAGE 📱</strong><br>
Java Version: Java 1.8 (Java 8)<br>
Compile SDK Version: Android 14.0 (UpsideDownCake, API 34)<br>
API: google maps, google place api<br>
DataBase : SQLite <br><br>

<strong>👏🏻 프로젝트 요약 👏🏻</strong><br>
인하공업전문대학 주변의 음식점을 google map에 표시하고, 리뷰 작성 기능과 함께 최다 리뷰를 받은 음식점, 최다 추천을 받은 음식점을 메인 화면에서 한눈에 볼 수 있도록 하여 사용자로 하여금 식당을 고를 때 생기는 결정 시간을 단축할 수 있도록 한다. 이 어플리케이션의 이용에 있어 목표 대상은 인하공업전문대학 재학생으로,
주변 음식점은 걸어서 가기 적당한 거리여야 한다고 생각하여 학교에서 1km 반경으로 제한하였다.<br><br>

<strong>💾 DB (SQLite) 💾</strong><br><br>
member 테이블(유저정보) <br>
CREATE TABLE "member" ( <br>
"id"TEXT, <br>
"password"TEXT, <br>
"email"TEXT, <br>
"name"TEXT, <br>
"is_manager"INTEGER DEFAULT 0, <br>
PRIMARY KEY("id") <br>
); <br> <br>

post 테이블(리뷰정보) <br>
PostID: Integer<br>
Title: Text<br>
Content: Text<br>
Authoer: Text<br>
Restaurant: Text<br>
Recommend: Boolean(DEFAULT 0) <br>
<img width="420" alt="스크린샷 2024-07-07 오전 7 05 50" src="https://github.com/taegyeong0225/mobile_app/assets/108190809/7ab4c8a8-3005-41b9-aa8f-a14ca97b7075"> <br> <br>

<strong>🏞️ 이미지 🏞️</strong><br>

<앱 아이콘><br>
<img width="126" alt="스크린샷 2024-07-07 오전 7 06 48" src="https://github.com/taegyeong0225/mobile_app/assets/108190809/1e4381a5-d440-401b-81bc-256d7381ef6a"> <br>

<각 탭 이미지 (로그인 전)>
<div style="display: flex;">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/2bf817d6-d983-40e4-afe6-9959837a772b" alt="main_page" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/74e03045-38e5-43cd-8032-2b60536458d8" alt="3번째 탭" width="200" height="400">  
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/dc422743-d28c-4c1d-9efa-22696b6be77d" alt="map" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/9d86e75c-a663-422f-8df5-379a81902273" alt="no_login" width="200" height="400">
</div> 

<로그인>

<div style="display: flex;">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/d2470c12-151d-444b-b95a-6451820a4566" alt="로그인 성공" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/e9df401c-d838-43e0-a05d-2c59bd85ddcd" alt="로그인 실패" width="200" height="400">
</div> <br>

<회원가입>

<div style="display: flex;">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/8b45e54e-93c5-4a11-96bd-248c4b242ab9" alt="회원가입 초기화면" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/bc8e5d53-e19d-4b0a-8b1d-ce08998b5bd3" alt="회원가입 아이디 채워라" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/8cc3c25f-97c7-4394-9141-704559a18d25" alt="중복확인 성공" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/cc6d2a5b-cb8f-4e64-b494-c39fe52c0370" alt="비밀번호 불일치" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/318be11e-e8e1-4676-98a8-69a0576cf1ac" alt="이미 존재하는 아이디" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/11535fba-e687-4bb9-b432-c91c09abfe8d" alt="회원가입 성공" width="200" height="400">
</div> <br>

<글 작성>
<div style="display: flex;">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/bf620236-f64d-4e03-bb4b-9e6fd5374d0e" alt="글작성 초기화면" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/0e89df65-2901-45b2-968a-0658847b6338" alt="글작성 중" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/9afc9d6e-fc1a-4185-8a7a-0cb75e699494" alt="글작성 시 카테고리" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/18df990e-d5d8-47f3-8233-f802856f9d9b" alt="글저장 완료" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/3a433629-58ce-40d2-af9f-d94c56282f44" alt="리스트 카테고리" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/13c4bfa6-e3b8-44ed-9f1f-7f1e087352f3" alt="금산양꼬치" width="200" height="400">
    <img src="https://github.com/taegyeong0225/mobile_app/assets/108190809/2adf7b30-7cb1-47bf-b608-21493b572cf4" alt="존재않함" width="200" height="400">
</div>

<style>
a {
    text-decoration: none;
}
</style>
