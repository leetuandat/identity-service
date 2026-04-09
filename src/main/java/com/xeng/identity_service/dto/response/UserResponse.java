/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 6/24/2025
 * @time: 11:34 AM
 * @package: com.xeng.identity_service.dto.response
 */

package com.xeng.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<String> roles;
}
