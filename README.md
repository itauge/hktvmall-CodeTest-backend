# HktvmallCodeTestBackend
####Backend: `SpringBoot`
####Frontend: `Angular`

## Setup

1. `docker-compose up -d`, run the PostgresSQL, the port number of the server is `5432`.

2. `mvnw spring-boot:run`, compile the web application, the port number of the server is `8080`.

3. http://127.0.0.1:8080/insertDb, access and automatically insert the data into the database

4. http://127.0.0.1:8080/alldata, access and test the data insert success or not.

5. https://github.com/itauge/hktvmall-CodeTest-frontend, access and clone the frontend project.

6. `npm install` and `ng serve` in the root frontend project, the port number of the server is `4200`

7. http://127.0.0.1:4200, ready for test

## Comment

###Day 1
Target  `->` Built up the backend API for getting the data\
Problem `->` Date format change\
Finish  `->` Whole backend API without the Date problem

###Day 2
Target `->` Built up the frontend interface\
Problem `->` Web page layout and receiving json issues\
Finish `->` Fix all the problem

###Day 3
finish the readme.md