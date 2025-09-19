package com.cafe.cafe_management_system.inventory.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SupplierResponseDTO extends BaseResponseDTO {

    @Schema(description = "Supplier name", example = "Coffee Beans Inc.")
    private String name;

    @Schema(description = "Contact person name", example = "John Doe")
    private String contactPerson;

    @Schema(description = "Supplier phone number", example = "+1234567890")
    private String phone;

    @Schema(description = "Supplier email address", example = "contact@coffeebeans.com")
    private String email;

    @Schema(description = "Supplier address", example = "123 Main St, City, Country")
    private String address;
}