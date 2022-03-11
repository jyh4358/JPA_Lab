# ORM 표준 JPA 프로그래밍


## 내용 정리

---

22.03.07
- [JPA의 등장](https://jddng.tistory.com/308) 
  - JPA 탄생 배경
- [JPA(Java Persistence API)란?](https://jddng.tistory.com/309)
  - JPA의 동작(조회, 저장)
  - JPA의 장점(생산성, 유지보수, 패더라임 불일치 해결, 성능 최적화)
- [JPA의 내부 동작과 Entity의 생명주기](https://jddng.tistory.com/310)
  - JPA의 내부동작
  - Entity의 생명주기(비영속, 영속, 준영속, 삭제)
- [영속성 컨텍스트](https://jddng.tistory.com/311)
  - 영속 컨텍스트에서 관리되는 1차 캐시
  - 동일성 보장(identity)
  - 트랜잭션을 지원하는 쓰기 지연(Transactional write-behind)
  - 변경 감지(Dirty Checking)
  - 지연 로딩(Lazy Loading)
  - 플러시(flush)
  - 준영속 상태
- [다양한 연관관계 매핑](https://jddng.tistory.com/314)
  - 다대일 [N : 1]
  - 일대다 [1 : N]
  - 일대일 [1 : 1]
  - 다대다 [N : M]

22.03.08
- [엔티티 매핑](https://jddng.tistory.com/312)
  - 데이터베이스 스키마 설정
  - 객체와 테이블 매핑
  - 필드와 컬럼 매핑
  - 기본 키 매핑 : 직접할당, 자동할당
  - @GeneratedValue의 IDENTITY 전략
- [연관관계 매핑](https://jddng.tistory.com/313)
  - 단방향 연관관계
  - 양방향 연관관계
- [상속관계 매핑](https://jddng.tistory.com/315)

22.03.10
- [프록시와 연관관계](https://jddng.tistory.com/316)
  - 프록시란?
  - 즉시 로딩과 지연 로딩
  - 영속성 전이(CASCADE)와 고아 객체

22.03.11
- [JPA 값 타입](https://jddng.tistory.com/317)
  - 기본값 타입
  - 임베디드 타입(복합 값 타입)
  - 값 타입과 불변 객체
  - 값 타입의 비교
  - 값 타입 컬렉션
- [JPA 기본 문법과 기능](https://jddng.tistory.com/318)
  - 집합과 정렬
  - 반환 타입
  - 결과 조회
  - 파라미터 바인딩
  - 프로젝션(SELECT)
  - 프로젝션(SELECT) - 여러 값 조회
  - 페이징 API
  - 조인
  - ON절을 활용한 조인
  - 서브 쿼리
  - JPQL 타입 표현
  - 조건식 -CASE
  - JPQL 기본 함수
- [JPQL 기본 문법 2](https://jddng.tistory.com/319)
  - 경로 표현식
    - 용어, 특징, 탐색
    - 명시적 조인과 묵시적 조인
  - 페치 조인(fetch join)
    - 엔티티 페치 조인
    - 컬렉션 페치 조인
    - 페치 조인과 일반 조인의 차이
    - 페치 조인의 한계
  - 다형성 쿼리
  - 쿼리에 엔티티 사용
  - 벌크 연산


## 학습 테스트 코드

---

22.03.07
- 동일성(identity) test
- 쓰기지연 test
- 변경감지 test
- 플러시 test
- 준영속 test

<img src="https://user-images.githubusercontent.com/97331219/157183179-1a58d084-a225-4fbb-8052-b58b87932b39.png" width="400" height="150">



22.03.08
- IDENTITY 전략 test
- SEQUENCE 전략 test

<img src="https://user-images.githubusercontent.com/97331219/157183411-2d6747a6-6ba8-4dc9-9981-6bfab2614d2a.png" width="400" height="150">

22.03.10
- 프록시와 영속성 컨텍스트 test
- 영속성 전이(cascade) test