# **Flight Reservation Services - RESTful API**

Welcome to the **Flight Reservation Services RESTful API**! This project represents a sophisticated, microservices-based architecture designed to streamline and enhance the flight reservation experience. Developed with the latest technologies and industry standards, this API provides a robust and secure solution for managing flight bookings, cancellations, ticketing, and more.

## 🚀 **Project Overview**

The **Flight Reservation Services RESTful API** is a multi-layered, microservices-oriented system. It is built to handle complex flight reservation scenarios, including flight searches, reservations, ticketing, and cancellations, while ensuring secure authentication and data integrity.

### 🌟 **Key Features**

- **Microservices Architecture**: Decomposed into multiple independent services, including:
  - **`Auth-Service`**: Handles secure user authentication and authorization.
  - **`FlightSearch-Service`**: Allows users to search for flights based on various criteria.
  - **`Reservation-Service`**: Manages flight reservations and stores relevant data.
  - **`Ticketing-Service`**: Handles ticket generation and payment processing.
  - **`Cancellation-Service`**: Manages ticket cancellations and processes refunds.
  - **`Reservation-Search-Service`**: Provides comprehensive search capabilities for existing reservations.

- **Security**: Implemented using **Spring Security** to ensure only authorized users can access sensitive operations.

- **Elasticsearch Integration**: All services are fully integrated with **Elasticsearch** for real-time log monitoring, allowing for efficient tracking and analysis of all operations.

- **Oracle Database**: The backbone of the data layer, providing a reliable and scalable relational database solution.

- **Dockerized Deployment**: Each service is containerized using **Docker**, allowing for consistent and reproducible deployment across different environments.

- **Nginx**: Serving as a reverse proxy, **Nginx** efficiently manages and distributes incoming requests to the appropriate services.

## 🛠️ **Technologies Used**

- **Java & Spring Boot**: The core framework used to develop the RESTful services, leveraging Spring Boot's powerful features to accelerate development.
- **Spring Security**: Provides robust authentication and authorization mechanisms.
- **Hibernate & JPA**: For ORM and database interaction, ensuring seamless integration with the Oracle Database.
- **Oracle Database**: A highly reliable and scalable database solution used for storing all flight, passenger, and reservation data.
- **Docker**: Containerization of all services for consistent and scalable deployments.
- **Elasticsearch**: Used for powerful log aggregation, search, and analysis.
- **Logstash & Kibana**: **Logstash** processes the logs from all services, and **Kibana** provides a rich interface for monitoring and analyzing logs.
- **Nginx**: Acts as a reverse proxy, efficiently managing and routing requests.

## 🌐 **API Endpoints**

Here's a summary of the main API endpoints exposed by the various services:

- **Auth-Service**:
  - `POST /auth/login` - Authenticate a user.
  - `POST /auth/register` - Register a new user.

- **FlightSearch-Service**:
  - `POST /flights/search` - Search for available flights.

- **Reservation-Service**:
  - `POST /reservations/create` - Create a new flight reservation.

- **Ticketing-Service**:
  - `POST /tickets/generate` - Generate a flight ticket.

- **Cancellation-Service**:
  - `POST /cancellation` - Cancel a flight reservation.

- **Reservation-Search-Service**:
  - `POST /api/reservation-search` - Search for a specific reservation.

## 🛡️ **Security**

The system is secured using **Spring Security**, ensuring that all sensitive operations are protected. Each service uses **JWT** for token-based authentication, providing a secure and stateless means of protecting user data.

## 🐳 **Deployment**

Deployment is simplified and standardized using **Docker**. Each service runs in its own container, ensuring isolation and scalability. The project can be easily set up and run on any environment that supports Docker.

## 📊 **Monitoring**

Real-time log monitoring and analysis are powered by the **ELK Stack** (Elasticsearch, Logstash, Kibana). This allows developers and administrators to monitor the health of the services, track requests, and troubleshoot any issues quickly and effectively.

## 💻 **Getting Started**

To get started with this project, clone the repository, and follow the instructions in the `docker-compose.yml` file to bring up all services using Docker. Make sure you have Docker and Docker Compose installed on your machine.
