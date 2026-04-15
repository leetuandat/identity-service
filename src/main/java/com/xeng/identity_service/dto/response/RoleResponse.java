/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 9/4/2025
 * @time: 03:21 PM
 * @package: com.xeng.identity_service.dto.response
 */

package com.xeng.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleResponse {
    String name;
    String description;
    Set<PermissionResponse> permissions;
}
