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
    1. Nested Loop 조인과 Sort Merge 조인의 문제점을 해결
    2. 대용량 처리의 선결조건인 랜덤 액세스와 정렬에 대한 부담을 해결할 수 있는 대안으로 등장
    3. Hash 조인만을 이용하는 것보다 parallel processing을 이용한 hash 조인은 대용량 데이터를 처리하기 위한 최적의 솔루션 제공
    4. 2개의 조인 테이블 중 small rowset을 가지고 hash_area_size에 지정된 메모리 내에서 hash table 생성
    5. Hash bucket이 조인집합에 구성되어 Hash 함수 결과를 저장하여야 하는데, 이러한 처리에 많은 메모리와 CPU자원이 소모됨
    6. CBO(Cost Based Optimizer) 모드에서 옵티마이저가 판단가능하며, 테이블의 통계정보가 있어야 함
    7. Hash table 생성 후 Nested Loop처럼 순차적인 처리 형태로 수행함

## *라. Hash Join사용시 주의사항
    1. 대용량 데이터 처리에서는 상당히 큰 hash area를 필요로 함으로, 메모리의 지나친 사용으로 오버헤드 발생 가능성
    2.연결조건 연산자가 ‘=’인 동치조인인 경우에만 가능

## *마. Hash Join사용시 주의사항
    1) 수행순서
           - 두 테이블을 스캔하여 사이즈가 작은 테이블을 선행 테이블로 결정
           - 선행 테이블을 이용하여 해쉬 테이블을 구성한다(Build Input)
           - 후행 테이블은 해쉬 값을 이용하여 선행 테이블과 조인한다(Prove Input)
      2) Build Input 크기
           -  Hash Area 만으로 Hash Table 생성이 불충분하다면 Hash Table Overflow가 발생
             내 Hash Area 사이즈를 증가 필요함
      3) 이용
           - 대용량 데이터 엑세스, 배치처리, 전체 테이블을 조인할 때 유리하다
           - 양쪽 테이블의 조건으로 각각 범위를 줄일 수 있을 때 유리하다
           - 병행 처리로 수행속도 향상이 가능하다
           - Hash Area 사이즈 조정으로 수행속도 향상이 가능하다
4. 조인 연산 비교

  가. Nested Loop와 Hash Joi의 비교
  
  구분 | Nested loop join | Hash join
  -----|-----------------|-----------
  대량의 범위|인덱스를 랜덤 액세스에 걸리는 부하가 가장 큰 문제점으로, 최악의 경우 하나의 ROW를 액세스하기 위해 Block단위로 하나하나 액세스를 해야 함.|적은 집합에 대하여 먼저 해시 값에 따른 Hash Bucket정보를 구성한 후 큰 집합을 읽어 해시 함수를 적용하여 Hash Bucket에 담기 전에 먼저 호가인해 볼 수 있기 때문에 해시조인이 효율적인 수행이 가능
  대량의 자료|다량의 랜덤 액세스 수행으로 인해 수행 속도가 저하|대용량 처리의 선결조건인 ‘랜덤 액세스’와 ‘정렬’에 대한 문제 개선과 H/W의 성능 개선을 통해 각 조인 집합을 한번 스캔하여 처리하기 때문에 디스크 액세스 면에서 훨씬 효율적
