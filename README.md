
# QuickMap

### 개요

병원 위치 검색, 추천 서비스 QuickMap입니다.<br>



#### 개발 일정
2023.05.15 ~ 2023.06.01

***

### 요구 사항



***

### 기술 스택
- 언어 : <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
- DB : <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> 
- Framework : <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=black"> 
- Library : <img src="https://img.shields.io/badge/chart.js-FF6384?style=for-the-badge&logo=chartdotjs&logoColor=black"> <img src="https://img.shields.io/badge/kakaomap-FFCD00?style=for-the-badge&logo=kakao&logoColor=black"> <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=black"> 
- 빌드/배포 : <img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=black"> <img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=black"> <img src="https://img.shields.io/badge/apachemaven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=black">

***

### 아키텍쳐


***

### 상세 기능

#### 지도
사용자는 메인 화면인 지도 화면에서 병원의 분포를 확인할 수 있습니다. 
일반적인 검색 기능 외에 증상을 입력하여 검색하는 기능이 있습니다.
증상과 병원 유형을 카테고리화 한 후 이들을 서로 연관시키는 검색 알고리즘을 만들고
거리 좌표를 이용하여 거리 설정에 따라 결과 범위를 조절할 수 있습니다.


#### 병원 등록 및 광고 등록
일반회원, 의료인 회원, 관리자 총 3종류의 Actor가 있습니다.
의료인 등급은 관리자의 승인을 받도록 하고, 프리미엄 결제를 하면 
해당 병원이 이용자의 검색 결과에서 상단에 배치됩니다.


***

### 팀원 구성 및 역할
<table>
    <tr>
        <th style="width: 30%;">Category</th>
        <th>Description</th>
    </tr>
  <tr>
        <td>박진우</td>
        <td>Back-end, Front-end, 서버 배포, CI/CD 환경 구축 <br>
        카카오맵 연동, 맵 UI/UX, 맵 데이터 시각화, 검색 알고리즘 구현, 서버 배포 </td>
    </tr>
    <tr>
        <td>한태희</td>
        <td>Back-end, Front-end, MachineLearning <br>
        관리자 페이지, 통계 페이지, 병원 데이터 전처리</td>
    </tr>
    <tr>
        <td>노지윤</td>
        <td>Back-end, Front-end, MachineLearning <br>
        회원 기능, 마이페이지, 리뷰 구현</td>
    </tr>
</table>



