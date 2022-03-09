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