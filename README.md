BOTH FRONTEND AND BACKEND CODE INSIDE "instaclone-backend folder". Sorry for this but due to less time.
A mini Instagram-like application built using Spring Boot (Backend) and React (Frontend).
This project implements core Instagram features such as user authentication, following users, creating posts, likes, comments, and a personalized feed.

🚀 Features
Backend (Spring Boot)

User Signup & Login
Password hashing using BCrypt
Follow & Unfollow users
Create posts (image URL + caption)
Like & Unlike posts
Comment on posts
Feed API showing posts from followed users
RESTful APIs with clean structure

MySQL database with JPA & Hibernate
Frontend (React)
User Login & Signup
Home feed showing posts
Create post form
Like & comment on posts
Profile page with follower/following count
Responsive UI
API integration using Fetch / Axios

🛠 Tech Stack
Backend
Java 17
Spring Boot 4
Spring Data JPA
Spring Security
MySQL
Hibernate
Maven
Frontend
React (Vite)
JavaScript


Backend Setup
Open instaclone-backend in IntelliJ
Create MySQL database:
CREATE DATABASE insta_clone_db;


Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/insta_clone_db
spring.datasource.username=root
spring.datasource.password=your_password


Run:
mvn spring-boot:run

Backend runs on:
http://localhost:8080

⚙️ Frontend Setup
Open -frontend folder
Install dependencies:

npm install

Start frontend:
npm run dev

Frontend runs on:
http://localhost:5173

🔌 API Examples
Register User
POST /api/auth/register

{
  "username": "aditya",
  "email": "aditya@gmail.com",
  "password": "123456"
}

Login
POST /api/auth/login
Create Post
POST /api/posts/{userId}

Testing
APIs tested using Postman
Database verified using MySQL

NOTES-
This project is built for learning and evaluation purposes
No external UI libraries used to keep the project simple
Code written manually with understanding of concepts
