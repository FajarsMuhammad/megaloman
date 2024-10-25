## Microservices Application Using Spring boot

To run this app you need following:

- JDK 8.+
- Maven 3.6.3
- MySQL 5.7.+

How to, run : 
- run kafka on your local first if you want to use kafka, kafka already on customer-service and fraud-service
- discovery-service
- gateway-service
- auth-service
- customer-service
- user-service
- employee-service
- fraud-service

for discovery service eureka : http://localhost:8761/

since we used gateway-service so every services host will be replaced to http://localhost:8222/ 

- Signup
```
curl --location 'localhost:8222/api/v1/auth/signup' \
--header 'Content-Type: application/json' \
--header 'X-API-Key: {{token}}' \
--data '{
    "name": "Admin",
    "username": "admin",
    "password": "password"
}'
```
- signin
```
curl --location 'localhost:8222/api/v1/auth/signin' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'X-API-Key: {{token}}' \
--data '{
    "username": "admin",
    "password": "password"
}'
```

- customer
```
curl --location 'localhost:8222/api/v1/customers' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcyOTU2NjU2MiwiZXhwIjoxNzI5NTY4MDAyfQ.qqU9GeVHv3zanIwCg-PN9rcOUiLXy9T7KRkp43khIig' \
--data-raw '{
    "firstName": "Fajars",
    "lastName": "Sudarmaji",
    "email": "fajar01@gmail.com"
}'
```

- Using Docker
```
- Docker Build from docker file
docker build -t app/name-service .
docker-compose up -d
```