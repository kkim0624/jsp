# 해시 조인(Hash Join)

## *가. Hash Join 알고리즘
 - 해싱 함수(Hashing Function)기법을 활용하여 조인을 수행하는 방식으로 해싱 함수는 직접적인 연결을 담당하는 것이 아니라 연결
   대상을 특정 지역(partition)에 모아두는 역알만을 담당함.
 - R의 애트리뷰터 A와 S의 애트리뷰트 B흫 해시 키로 하고, 동일한 해시 함수를 사용하여 해시
   - 1단계(분할 단계, partition phase) : 더 적은 수의 레코드를 가진 화일(R)의 레코드들을 해시 파일 버켓들로 해시 
   - 2단계(조사 단계, probing Phase): 다른 파일(S)의 각 레코드를 해시하여 R에서 동일한 해시 주소를 갖는 버켓 내의 레코드들이 실제로 조인 조건을 
     만족하면 두 레코드를 결합
     
## *나. 사용법 및 사용예제
  - 힌트: /*+ USE_HASH(A B) */
  
     select /*+ use_hash(a b) */ a.dname, b.empno, b.ename
     from dept a, emp b
     where a.deptno = b.deptno
     and a.deptno between 10 and 20;

## *다. Hash Join의 특징
    * Nested Loop 조인과 Sort Merge 조인의 문제점을 해결
    * 대용량 처리의 선결조건인 랜덤 액세스와 정렬에 대한 부담을 해결할 수 있는 대안으로 등장
    * Hash 조인만을 이용하는 것보다 parallel processing을 이용한 hash 조인은 대용량 데이터를 처리하기 위한 최적의 솔루션 제공
    * 2개의 조인 테이블 중 small rowset을 가지고 hash_area_size에 지정된 메모리 내에서 hash table 생성
    * Hash bucket이 조인집합에 구성되어 Hash 함수 결과를 저장하여야 하는데, 이러한 처리에 많은 메모리와 CPU자원이 소모됨
    * CBO(Cost Based Optimizer) 모드에서 옵티마이저가 판단가능하며, 테이블의 통계정보가 있어야 함
    * Hash table 생성 후 Nested Loop처럼 순차적인 처리 형태로 수행함


4. 조인 연산 비교

  가. Nested Loop와 Hash Joi의 비교
  
  구분 | Nested loop join | Hash join
  -----|-----------------|-----------
  
