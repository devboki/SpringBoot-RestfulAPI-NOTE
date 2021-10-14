## Spring Boot + JPA + Oracle + RestfulAPI NOTE
CRUD가 가능한 간단한 노트 구현.  
DB에 테이블을 생성한 후 (Repository 내 SQL파일 참조) Oracle과 JPA를 사용하기 위한 Dialect를 설정하고  
Getter, Setter를 자동으로 생성해주기 위한 Lombok,  
유효성 검사를 위한 Valid Annotation을 Dependency에 추가하였다.  
Postman에서 API TEST시 POST localhost/api/notes -> JSON 방식으로 title과 content를 전송하면  
GET localhost/api/notes 에서 테이블 내용을 확인할 수 있고  
id Number로 Update(PUT)와 Delete가 가능하다.

- Java 1.8
- Oracle 11g
- Maven
