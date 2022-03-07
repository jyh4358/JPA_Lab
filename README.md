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


## 학습 테스트 코드

---

22.03.07
- 동일성(identity) test


<img src="https://user-images.githubusercontent.com/97331219/156993397-a1b91c47-4b38-4120-a4a7-f7e8de4c6097.png" width="400" height="300">


- 쓰기지연 test

<img src="https://user-images.githubusercontent.com/97331219/156993981-0a72aa59-f688-4071-86f3-74ad3adfe882.png" width="400" height="300">


- 변경감지 test

<img src="https://user-images.githubusercontent.com/97331219/156994707-286f6ce2-c47f-472f-8c44-484e91e3fed9.png" width="400" height="300">

- 플러시 test

<img src="https://user-images.githubusercontent.com/97331219/156995179-bc1a39ca-01a6-4b9e-8e55-509d2106f9bc.png" width="400" height="300">

- 준영속 test

<img src="https://user-images.githubusercontent.com/97331219/156995373-8b13f631-e70e-4d65-b806-9963a98b60e9.png" width="400" height="300">


