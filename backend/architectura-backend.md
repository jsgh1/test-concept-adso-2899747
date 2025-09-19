# Backend Architecture - Café Management System

## Introduction

This document describes the backend architecture for the **Café Management System**, an application developed with Java and Spring Boot that allows managing a café's products, inventory, ingredients, and promotions efficiently.

## Technologies Used

### Core Technologies
- **Java 17+**: Main programming language.
- **Spring Boot 3.x**: Framework for rapid Java application development.
- **Spring Data JPA**: Abstraction for relational data access.
- **MySQL 8+**: Relational database with robust transaction support.

### Additional Libraries
- **Lombok**: Reduction of repetitive code.
- **Swagger/OpenAPI**: Automatic API documentation.

### DevOps & Tools
- **Maven**: Dependency management and build.
- **Git**: Version control.

## General Architecture

The system follows a modular architecture with clear responsibility separation. Each module handles a specific part of the business domain, maintaining organized and maintainable code.

## Folder Structure

```
src/main/java/com/cafe/cafe_management_system/
├── config/                    # Global configurations
├── product/                   # Product Management Module
│   ├── controller/            # REST endpoints
│   ├── service/               # Business logic
│   ├── repository/            # Data access
│   └── model/                 # JPA entities
├── inventory/                 # Inventory Management Module
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── model/
├── promotion/                 # Promotions Module
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── model/
├── parameterization/          # Parameterization Module
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── model/
├── security/                  # Security Module
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── model/
└── CafeManagementSystemApplication.java   # Main class
```

## Module Descriptions

### Product Management Module
Handles all product-related operations and configurations.
- **category**: Product categories and classifications
- **product**: Individual product information
- **ingredient**: Raw materials and ingredients
- **product_ingredient**: Product-ingredient relationships and quantities
- **table**: Café tables and seating information

### Inventory Management Module
Controls stock levels and supplier information.
- **supplier**: Supplier contact and details
- **inventory_item**: Stock tracking for products and ingredients

### Promotions Module
Manages promotional campaigns and discounts.
- **promotion**: Promotional campaign configurations
- **Note**: Promotions can be percentage-based or fixed amount discounts

### Parameterization Module
Contains system master data and configurations.
- **role**: User roles in the system
- **payment_method**: Available payment methods for transactions

### Security Module
Manages user access credentials.
- **user**: User authentication information

## REST API

The API exposes CRUD endpoints for entities by module:

### Product Management API
```
GET    /api/categories            # List categories
GET    /api/categories/{id}       # Get category by ID
POST   /api/categories            # Create category
PUT    /api/categories/{id}       # Update category
DELETE /api/categories/{id}       # Delete category

GET    /api/products              # List products
GET    /api/products/{id}         # Get product by ID
POST   /api/products              # Create product
PUT    /api/products/{id}         # Update product
DELETE /api/products/{id}         # Delete product

GET    /api/ingredients           # List ingredients
GET    /api/ingredients/{id}      # Get ingredient by ID
POST   /api/ingredients           # Create ingredient
PUT    /api/ingredients/{id}      # Update ingredient
DELETE /api/ingredients/{id}      # Delete ingredient

GET    /api/tables                # List café tables
GET    /api/tables/{id}           # Get table by ID
POST   /api/tables                # Create table
PUT    /api/tables/{id}           # Update table
DELETE /api/tables/{id}           # Delete table
```

### Inventory Management API
```
GET    /api/suppliers             # List suppliers
GET    /api/suppliers/{id}        # Get supplier by ID
POST   /api/suppliers             # Create supplier
PUT    /api/suppliers/{id}        # Update supplier
DELETE /api/suppliers/{id}        # Delete supplier

GET    /api/inventory-items       # List inventory items
GET    /api/inventory-items/{id}  # Get inventory item by ID
POST   /api/inventory-items       # Create inventory item
PUT    /api/inventory-items/{id}  # Update inventory item
DELETE /api/inventory-items/{id}  # Delete inventory item
```

### Promotions API
```
GET    /api/promotions            # List promotions
GET    /api/promotions/{id}       # Get promotion by ID
POST   /api/promotions            # Create promotion
PUT    /api/promotions/{id}       # Update promotion
DELETE /api/promotions/{id}       # Delete promotion
```

### Parameterization API
```
GET    /api/roles                 # List roles
GET    /api/payment-methods       # List payment methods
GET    /api/payment-methods/{id}  # Get payment method by ID
POST   /api/payment-methods       # Create payment method
PUT    /api/payment-methods/{id}  # Update payment method
DELETE /api/payment-methods/{id}  # Delete payment method
```

### Security API
```
GET    /api/users                 # List users
GET    /api/users/{id}            # Get user by ID
POST   /api/users                 # Create user
PUT    /api/users/{id}            # Update user
DELETE /api/users/{id}            # Delete user
```

## Database

### Schema Strategy
Each module has its own schema in MySQL to maintain data separation and facilitate maintenance.

### System Schemas

#### product_schema
```sql
CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE ingredient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    unit VARCHAR(20) NOT NULL
);

CREATE TABLE product_ingredient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    ingredient_id BIGINT NOT NULL,
    quantity DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);

CREATE TABLE cafe_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    table_number INT NOT NULL UNIQUE,
    capacity INT NOT NULL,
    location VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE
);
```

#### inventory_schema
```sql
CREATE TABLE supplier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact_person VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(150),
    address TEXT
);

CREATE TABLE inventory_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    supplier_id BIGINT,
    product_id BIGINT,
    ingredient_id BIGINT,
    quantity DECIMAL(10,2) NOT NULL,
    unit_price DECIMAL(10,2),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);
```

#### promotion_schema
```sql
CREATE TABLE promotion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    discount_type ENUM('PERCENTAGE', 'FIXED') NOT NULL,
    discount_value DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    active BOOLEAN DEFAULT TRUE
);
```

#### parameterization_schema
```sql
CREATE TABLE role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE payment_method (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(200),
    is_active BOOLEAN DEFAULT TRUE,
    processing_fee DECIMAL(5,2) DEFAULT 0.0
);
```

#### security_schema
```sql
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (role_id) REFERENCES parameterization_schema.role(id)
);
```

## Architecture Pattern

### MVC Pattern by Module
Each module follows the Model-View-Controller pattern:
- **Model**: JPA entities representing database tables
- **Repository**: Interfaces extending JpaRepository for data access
- **Service**: Module business logic
- **Controller**: REST endpoints exposing functionality

### Advantages of the Approach
- **Clear separation**: Each module is independent
- **Maintainability**: Easy to locate and modify code
- **Scalability**: New modules can be added without affecting others
- **Testability**: Each module can be tested in isolation

## Conclusion

This architecture provides a solid and simple foundation for the Café Management System. The module separation facilitates development and maintenance, while Spring Boot accelerates the development process.

The system is designed to be functional from the start, with room for adding more advanced features like security and microservices in the future.