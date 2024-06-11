# spring-module-common
## 💡 목적
어플리케이션과 웹의 공통 사용 부분 공유

## 💡 기능
**관련 내용 공유**
<br>repository, domain, enum, dto 등 웹과 어플리케이션에서 공통으로 사용하는 부분 공유

- Entity의 경우 `spring-module-base`를 상속받아 사용
  - 데이터 구조를 동일시 하기 위해 사용
- Exception의 경우 `spring-module-base`를 상속한 것과 하지 않은 것이 있음
  - 주로 어플리케이션에서 사용하는 exception의 경우 상속하지 않음
  - 웹에서 사용하는 exception의 경우 상속해서 사용
  
---
# 서브모듈 등록
git clone 시 서브모듈도 함께 받을 수 있도록 해야 함
```
$ git clone --recursive https://github.com/username/repo.git
```

- spring-module-auth
  - 로그인/회원가입 관련 모듈 (아직 Web에는 적용하지 않음)
- spring-module-base
  - Entity와 Exception 구조 통일을 위한 기본 모듈 (CRUD의 경우도 완성되어 있으나, 이는 필요시 사용)
- spring-module-common
  - 어플리케이션과의 공통 내용을 가짐 (ex. Store, User 등)
