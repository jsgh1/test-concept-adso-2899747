# UML Class Diagram - Café Management System

**PlantUML File:** `clases-uml.wsd`

```plantuml
@startuml UML Class Diagram

' Entidades principales del módulo Product
class Category {
    +id: Long
    +name: String
    +description: String
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

class Product {
    +id: Long
    +name: String
    +description: String
    +price: BigDecimal
    +categoryId: Long
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

class Ingredient {
    +id: Long
    +name: String
    +description: String
    +unit: String
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

class ProductIngredient {
    +id: Long
    +productId: Long
    +ingredientId: Long
    +quantity: BigDecimal
    +createdAt: LocalDateTime
}

class Table {
    +id: Long
    +tableNumber: Integer
    +capacity: Integer
    +location: String
    +isActive: Boolean
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

' Entidades del módulo Inventory
class Supplier {
    +id: Long
    +name: String
    +contactPerson: String
    +phone: String
    +email: String
    +address: String
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

class InventoryItem {
    +id: Long
    +supplierId: Long
    +productId: Long
    +ingredientId: Long
    +quantity: BigDecimal
    +unitPrice: BigDecimal
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

' Entidades del módulo Promotion
class Promotion {
    +id: Long
    +name: String
    +description: String
    +discountType: String
    +discountValue: BigDecimal
    +startDate: LocalDate
    +endDate: LocalDate
    +active: Boolean
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

' Entidades del módulo Parameterization
class Role {
    +id: Long
    +name: String
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

class PaymentMethod {
    +id: Long
    +name: String
    +description: String
    +isActive: Boolean
    +processingFee: Double
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

' Entidades del módulo Security
class User {
    +id: Long
    +username: String
    +password: String
    +roleId: Long
    +active: Boolean
    +createdAt: LocalDateTime
    +updatedAt: LocalDateTime
}

' Relaciones de composición
Product "1" *-- "0..*" ProductIngredient : contains
Category "1" *-- "0..*" Product : categorizes

' Relaciones de asociación
ProductIngredient --> Ingredient : uses
InventoryItem --> Supplier : supplied by
InventoryItem --> Product : tracks
InventoryItem --> Ingredient : tracks
User --> Role : has
Promotion --> Product : applies to

@enduml