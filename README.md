# 🚀 Trip Management System (Spring Boot + Hibernate + MySQL)

## 📌 Internship Project Overview
This project is developed as part of the *Java Spring Boot + Hibernate Internship Assignment* at *Badkul Technology Pvt Ltd*.  
The application is a *Trip Management System* that allows users to manage travel trips with CRUD functionality, filtering, searching, pagination, validations, and API documentation.  

How to Run the Project

1.Clone the Repository

git clone https://github.com/Abhi88732/JAVA-SEP-2025-3.git cd JAVA-SEP-2025-3

2.Configure Database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/tripdb spring.datasource.username=root spring.datasource.password=Example@2022# spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true

3.Run the Application

mvn spring-boot:run

4.Access Swagger API Documentation 👉 http://localhost:8080/swagger-ui.html

📡 API Endpoints 
Trip APIs 
Method Endpoint Desc 
POST /api/trips Create a new trip Body: { "destination": "Paris", "startDate": "2025-09-10", "endDate": "2025-09-20", "price": 1500, "status": "PLANNED" } 
GET /api/trips Get all trips (with pagination & sorting) /api/trips?page=0&size=5&sort=startDate,asc 
GET /api/trips/{id} Get trip by ID /api/trips/1 
PUT /api/trips/{id} Update trip by ID Body: { "destination": "London", "startDate": "2025-09-15", "endDate": "2025-09-25", "price": 1800, "status": "ONGOING" } 
DELETE /api/trips/{id} Delete trip by ID /api/trips/3
GET /api/trips/search?destination=Paris Search trips by destination /api/trips/search?destination=Paris 
GET /api/trips/filter?status=PLANNED Filter trips by status /api/trips/filter?status=PLANNED 
GET /api/trips/daterange?start=2025-09-01&end=2025-09-30 Get trips between dates /api/trips/daterange?start=2025-09-01&end=2025-09-30 
GET /api/trips/summary Get trip summary Response: { "totalTrips": 50, "minPrice": 500, "maxPrice": 4500, "averagePrice": 2200 }
