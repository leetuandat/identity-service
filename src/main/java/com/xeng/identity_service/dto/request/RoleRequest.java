/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 9/4/2025
 * @time: 03:20 PM
 * @package: com.xeng.identity_service.dto.request
 */

package com.xeng.identity_service.dto.request;

import com.xeng.identity_service.entity.Permission;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest {
    String name;
    String description;
    Set<String> permissions;
}
