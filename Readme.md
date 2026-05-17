# STEM Learning Game – SIT333

## Overview

This project is a STEM learning web application developed using Java, JSP, Maven, Selenium, and JUnit.

The application allows users to:
- Login
- Solve math questions
- Solve date utility questions
- Answer a science question

The project also demonstrates:
- Unit testing
- Functional testing
- Selenium automation
- Issue tracking using Jira

---

# Features

## Login System
- Username validation
- Password validation
- Date of birth validation

## STEM Questions
1. Addition
2. Subtraction
3. Multiplication
4. Find next day
5. Find previous week date
6. Science question

---

# Testing

## Unit Testing
JUnit tests were created for:
- Math operations
- Date operations
- Science question validation
- Login validation

## Functional Testing
Selenium tests verify:
- Full STEM game flow
- Invalid login handling
- Wrong answer handling
- Page navigation

---

# Technologies Used

- Java
- JSP
- Maven
- Selenium WebDriver
- JUnit 5
- ChromeDriver

---

# Project Structure

web.handler
- RoutingServlet.java

web.service
- LoginService.java
- MathQuestionService.java
- RegistrationService.java

src/test/java
- TestMathQuestionService.java
- TestLoginService.java
- MathGameSeleniumTest.java

---

# How to Run

1. Import project into Eclipse as Maven project
2. Update Maven dependencies
3. Run the application
4. Open browser:
http://localhost:8080

---

# Test Credentials

Username:
palak

Password:
palak_pass

Date of Birth:
1990-01-01

---

# Author

Palak
SIT333 – Software Quality and Testing