# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 경험해야할 학습 목표
* 레거시 코드를 리팩터링할 때 테스트 코드를 통해 보호하는 경험
* Q&A 서비스의 질문 삭제하기 기능의 레거시 코드를 리팩터링하는 경험
* DB 테이블보다 도메인 모델을 TDD 기반으로 먼저 개발해 보는 경험
* 레거시 코드를 점진적으로 리팩터링해보는 경험
* 현장과 유사한 기능 요구사항을 지금까지 학습한 TDD, OOP, 클린 코드 기반으로 개발해 보는 경험

## 객체지향 생활 체조 원칙
* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
* 규칙 2: else 예약어를 쓰지 않는다.
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 4: 한 줄에 점을 하나만 찍는다.
* 규칙 5: 줄여쓰지 않는다(축약 금지).
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
* 규칙 8: 일급 콜렉션을 쓴다.
* 규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

## 수강 신청 기능 요구사항
* 과정(Course)은 기수 단위로 여러 개의 강의(Session)를 가질 수 있다.
* 강의는 시작일과 종료일을 가진다.
* 강의는 강의 커버 이미지 정보를 가진다.
* 강의는 무료 강의와 유료 강의로 나뉜다.
* 강의 상태는 준비중, 모집중, 종료 3가지 상태를 가진다.
* 강의 수강신청은 강의 상태가 모집중일 때만 가능하다.
* 강의는 강의 최대 수강 인원을 초과할 수 없다.

## 프로그래밍 요구사항
* DB 테이블 설계 없이 도메인 모델부터 구현한다.
* 도메인 모델은 TDD로 구현한다.
* 단, Service 클래스는 단위 테스트가 없어도 된다.
* 다음 동영상을 참고해 DB 테이블보다 도메인 모델을 먼저 설계하고 구현한다.
* 도메인 모델을 DB 테이블과 매핑하고, 데이터를 저장한다.

## 기능 목록
* [x] 과정(Course) / 유저(LmsUser) 도메인 및 기능 생성
* [x] 강의(Session) 도메인 (시작일, 종료일, 커버이미지, 유료여부, 상태, 최대 수강인원) 및 기능 생성
* [x] 강의(Session) 도메인에 수강신청 기능 구현
* [x] 도메인 모델을 DB 테이블과 매핑 (LmsUser)
* [ ] 도메인 모델을 DB 테이블과 매핑 (Course)
* [ ] 도메인 모델을 DB 테이블과 매핑 (Session)
