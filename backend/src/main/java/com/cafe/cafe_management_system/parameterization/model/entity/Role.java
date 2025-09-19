package com.cafe.cafe_management_system.parameterization.model.entity;

import com.cafe.cafe_management_system.shared.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "role", schema = "parameterization_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    @Column(name = "name", nullable = false, length = 50)
    @Schema(description = "Role name", example = "ADMIN")
    private String name;
}
