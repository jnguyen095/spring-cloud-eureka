# How to Start
1. Run sql in folder: database
2. Start EurekaService 
3. Other services 
4. ZuulGateWay

# Authentication
1. Access: http://localhost:8083/oauth/token (Post) 
   * Authentication: type: Basic Auth, username: client, password: secret
   * Body: username: admin, password: 123456, grant_type: password
2. Access: http://localhost:8083/api/logon [role: LOGON]
   * Header: Authorization with value: bearer 36341a50-a6ee-4d0a-8379-e107dca21352'
   * Access: http://localhost:8083/api/user [role: USER]
   * Access: http://localhost:8083/api/admin [role: ADMIN] 
3. Feign client: http://localhost:8080/product-service/api/product/users/admin
   * Service product -> call to -> Service user as an example
4. Postman: [[local test.postman_collection.json]](https://github.com/jnguyen095/spring-cloud-eureka/blob/master/document/local%20test.postman_collection.json)   
