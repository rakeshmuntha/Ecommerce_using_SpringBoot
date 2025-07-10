# **E-Commerce Application**

## **Project Overview**

This is a full-stack e-commerce web application developed using **React.js** for the frontend and **Spring Boot** for the backend. The application allows users to view products, add them to a cart, and manage products from the backend. It is built to demonstrate integration between a modern frontend and RESTful Spring Boot APIs using a **MySQL** database for persistent data storage.

## **Features**

- **Product Listing**: Displays available products with image, name, and description.
- **Add to Cart**: Enables users to add products to their cart and view selected items.
- **CRUD Operations**: Backend APIs allow Create, Read, and Delete operations on products.
- **Category View (Optional)**: Products can optionally be grouped by category in the frontend.
- **Responsive UI**: The interface is built using **Bootstrap** for responsiveness across devices.

## **Technologies Used**

- **Frontend**: React.js, Bootstrap, Axios  
- **Backend**: Java, Spring Boot, Spring MVC, Spring Data JPA  
- **Database**: MySQL  
- **Tools**: IntelliJ IDEA, Postman  

## **How to Use**

1. **Set Up Backend**:
   - Start MySQL and create a new database named `ecommerce`.
   - Open `application.properties` and configure:
     - JDBC URL
     - MySQL username
     - MySQL password
   - Open the backend folder in **IntelliJ IDEA** and run the `EcommerceApplication.java` main file.

2. **Set Up Frontend**:
   - Open terminal and navigate to the frontend directory.
   - Install dependencies:
     ```bash
     npm install
     ```
   - Start the React app:
     ```bash
     npm start
     ```

3. **Access the Application**:
   - Backend runs on: `http://localhost:8080`
   - Frontend runs on: `http://localhost:3000`

## **Installation**

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rakeshmuntha/Ecommerce_using_SpringBoot.git
   ```

2. **Backend Setup**:
   - Open the backend in **IntelliJ IDEA**.
   - Configure DB connection in `application.properties`.
   - Run the Spring Boot main file.

3. **Frontend Setup**:
   ```bash
   cd frontend
   npm install
   npm start
   ```
