# CRUDp

## 주제
### CRUD 토이프로젝트

### 구현 기능
1. 로그인
2. 회원가입
3. 로그아웃
4. 게시판 리스트
5. 게시판 디테일
6. 게시판 등록
7. 게시판 삭제
8. 어드민 기능

## 유저
### 회원가입

- 일반 유저 로그인을 위한 회원가입 기능
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/a290b1a2-4d79-40b5-9d35-a2140e263428)
- 폼 입력이 안되었을시 메세지 출력
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/1ccac337-c4fb-417e-bb73-e65659b2c396)
- 폼 입력시 버튼 활성화 & 회원가입 실패시 회원가입 폼 재 로딩
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/e353c530-85e7-45e5-9cf9-04ee48881fc2)

### 로그인

- 회원가입후 로그인시 메인페이지로 이동 & 실패시 로그인페이지 재 출력
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/80d7a28b-c9ad-4cdf-8b11-0a7d284e155f)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/c711079f-1def-4b65-9641-559a7ee79732)
-> 로그인시 사용자 상태 관리는 Session을 통해서 이루어짐

### 게시판 리스트

- 게시판 접속시 등록 최신순으로 나타나게됨
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/50e98b0c-6548-454e-8ebc-fd90f93daa1b)
- 검색 기능 구현
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/681ed865-ce38-4c07-807c-a9ff679a0014)
- 작성자 검색 기능
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/02fef744-89dd-469f-8b5b-5286a9e5b00a)
- 페이지 이동시 검색 query 상태 유지
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/64024b39-9a02-445f-945f-db82b1ab94d6)

### 게시물 등록

- 게시판 등록시 사용자 상태 확인후 작성자가 등록
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/f703e3ad-b8fe-4182-91e3-f6f933438dae)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/6f24ce77-fd5c-4656-a070-52a99ec8db39)

### 게시물 디테일

- 게시판 리스트에서 제목 클릭시 디테일 페이지 접속
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/386bb9bb-d13d-460b-8f98-5de42807d5dc)
- 다음글, 이전글 이동 링크 구현
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/459ebafc-23e2-4890-8619-33c55f58a197)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/c33bf716-1d76-4d7d-87e1-d03402b1ac76)


### 게시물 수정

- 작성한 게시물이 본인일 경우에 수정, 삭제 버튼 활성화되어 나타남
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/0ebe832e-b00c-4326-b79c-13dc0b6c27a3)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/618a65b7-d1fa-4463-9a2a-d0286a3f46c4)
- 수정 버튼 클릭시 기존의 데이터값이 들어오게 되고 수정시 Update 된 게시물 등록
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/a4485747-8c06-4510-b0e2-fd470d699a34)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/6b8fe22a-14a1-42cd-890e-ee85b79436a6)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/09a6ba74-b544-4352-b59b-fa75e25ef231)

### 게시물 삭제

- 게시물 삭제 버튼 또한 사용자 본인일 경우 삭제 가능
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/e4a24dfc-0c03-47dd-8a41-21feece09c2b)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/bc2d4749-c94d-4bb2-addd-98578f79d59f)

### 댓글 등록

- 선택한 게시물에 댓글 등록
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/0b3c5aab-7a44-4641-9d42-a63d02a540d6)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/475de78a-5dc9-4e0a-88ff-8fe44fef2760)

### 댓글 삭제

- 댓글 등록한 작성자의 경우 삭제 버튼 활성화
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/6826017f-af3a-4abe-a522-7e745c657449)
![image](https://github.com/Sn-bow/CRUDp/assets/107871028/9cf58674-c1e2-4a66-ad4d-1fdef173ad90)

