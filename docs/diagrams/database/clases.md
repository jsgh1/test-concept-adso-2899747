# Entity-Relationship Model (MER) - Café Management System

**PlantUML File:** `clases.wsd`

```plantuml
@startuml Entity-Relationship Model (MER)

package "product_schema" {
    class category {
        +id: Long
        +name: String
        +description: String
        +created_at: DateTime
        +updated_at: DateTime
    }

    class product {
        +id: Long
        +name: String
        +description: String
        +price: Decimal
        +category_id: Long
        +created_at: DateTime
        +updated_at: DateTime
    }

    class ingredient {
        +id: Long
        +name: String
        +description: String
        +unit: String
        +created_at: DateTime
        +updated_at: DateTime
    }

    class product_ingredient {
        +id: Long
        +product_id: Long
        +ingredient_id: Long
        +quantity: Decimal
        +created_at: DateTime
    }

    class cafe_table {
        +id: Long
        +table_number: Integer
        +capacity: Integer
        +location: String
        +is_active: Boolean
        +created_at: DateTime
        +updated_at: DateTime
    }

    category ||--o{ product : categorizes
    product ||--o{ product_ingredient : contains
    ingredient ||--o{ product_ingredient : used_in
}

package "inventory_schema" {
    class supplier {
        +id: Long
        +name: String
        +contact_person: String
        +phone: String
        +email: String
        +address: String
        +created_at: DateTime
        +updated_at: DateTime
    }

    class inventory_item {
        +id: Long
        +supplier_id: Long
        +product_id: Long
        +ingredient_id: Long
        +quantity: Decimal
        +unit_price: Decimal
        +created_at: DateTime
        +updated_at: DateTime
    }

    supplier ||--o{ inventory_item : supplies
    product ||--o{ inventory_item : tracks
    ingredient ||--o{ inventory_item : tracks
}

package "promotion_schema" {
    class promotion {
        +id: Long
        +name: String
        +description: String
        +discount_type: String
        +discount_value: Decimal
        +start_date: Date
        +end_date: Date
        +active: Boolean
        +created_at: DateTime
        +updated_at: DateTime
    }

    product ||--o{ promotion : can_have
}

package "parameterization_schema" {
    class role {
        +id: Long
        +name: String
        +created_at: DateTime
        +updated_at: DateTime
    }

    class payment_method {
        +id: Long
        +name: String
        +description: String
        +is_active: Boolean
        +processing_fee: Decimal
        +created_at: DateTime
        +updated_at: DateTime
    }
}

package "security_schema" {
    class user {
        +id: Long
        +username: String
        +password: String
        +role_id: Long
        +active: Boolean
        +created_at: DateTime
        +updated_at: DateTime
    }

    user --> role : has
}

' Cross-schema relationships
product ||--o{ inventory_item : tracked_by
ingredient ||--o{ inventory_item : tracked_by
supplier ||--o{ inventory_item : supplied_by

@enduml