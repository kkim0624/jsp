# 해시 조인(Hash Join)

## * Hash Join 알고리즘
 - 해싱 함수(Hashing Function)기법을 활용하여 조인을 수행하는 방식으로 해싱 함수는 직접적인 연결을 담당하는 것이 아니라 연결
   대상을 특정 지역(partition)에 모아두는 역알만을 담당함.
 - R의 애트리뷰터 A와 S의 애트리뷰트 B흫 해시 키로 하고, 동일한 해시 함수를 사용하여 해시
   - 1단계(분할 단계, partition phase) : 더 적은 수의 레코드를 가진 화일(R)의 레코드들을 해시 파일 버켓들로 해시 


4. 조인 연산 비교

  가. Nested Loop와 Hash Joi의 비교
  
  구분 | Nested loop join | Hash join
  -----|-----------------|-----------
  
