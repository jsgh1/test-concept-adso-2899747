# Sequence Diagram - Create Product

**PlantUML File:** `secuencia.wsd`

```plantuml
@startuml Sequence Diagram - Create Product

actor "Manager" as M
participant "System" as S
participant "ProductController" as PC
participant "ProductService" as PS
participant "ProductRepository" as PR
participant "Database" as DB

M -> S: Access product management
S -> PC: GET /api/products (list products)
PC -> PS: findAll()
PS -> PR: findAll()
PR -> DB: SELECT * FROM product
DB --> PR: Return products
PR --> PS: Return products
PS --> PC: Return products
PC --> S: Return products
S --> M: Display products list

M -> S: Request to create new product
S -> PC: POST /api/products (create product)
PC -> PS: create(productRequest)
PS -> PS: validate product data
PS -> PR: save(product)
PR -> DB: INSERT INTO product
DB --> PR: Return saved product
PR --> PS: Return saved product
PS --> PC: Return product response
PC --> S: Return success response
S --> M: Product created successfully

@enduml