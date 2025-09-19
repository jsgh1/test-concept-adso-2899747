package com.cafe.cafe_management_system.inventory.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SupplierRequestDTO extends BaseRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Supplier name", example = "Coffee Beans Inc.")
    private String name;

    @Size(max = 100, message = "Contact person name cannot exceed 100 characters")
    @Schema(description = "Contact person name", example = "John Doe")
    private String contactPerson;

    @Pattern(regexp = "^\\+?[0-9\\s\\-\\(\\)]+$", message = "Phone number format is invalid")
    @Schema(description = "Supplier phone number", example = "+1234567890")
    private String phone;

    @Email(message = "Email format is invalid")
    @Schema(description = "Supplier email address", example = "contact@coffeebeans.com")
    private String email;

    @Schema(description = "Supplier address", example = "123 Main St, City, Country")
    private String address;
}