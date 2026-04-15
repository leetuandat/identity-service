/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 2/18/2025
 * @time: 01:47 PM
 * @package: com.xeng.identity_service.entity
 */

package com.xeng.identity_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Role {
    @Id
    String name;
    String description;

    @ManyToMany
    Set<Permission> permissions;
}
