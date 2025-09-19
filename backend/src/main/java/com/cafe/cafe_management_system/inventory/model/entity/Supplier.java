package com.cafe.cafe_management_system.inventory.model.entity;

import com.cafe.cafe_management_system.shared.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "supplier", schema = "inventory_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class Supplier extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Supplier name", example = "Coffee Beans Inc.")
    private String name;

    @Column(name = "contact_person", length = 100)
    @Schema(description = "Contact person name", example = "John Doe")
    private String contactPerson;

    @Column(name = "phone", length = 20)
    @Pattern(regexp = "^\\+?[0-9\\s\\-\\(\\)]+$", message = "Phone number format is invalid")
    @Schema(description = "Supplier phone number", example = "+1234567890")
    private String phone;

    @Column(name = "email", length = 150)
    @Email(message = "Email format is invalid")
    @Schema(description = "Supplier email address", example = "contact@coffeebeans.com")
    private String email;

    @Column(name = "address", columnDefinition = "TEXT")
    @Schema(description = "Supplier address", example = "123 Main St, City, Country")
    private String address;
}
