/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 2/18/2025
 * @time: 01:56 PM
 * @package: com.xeng.identity_service.dto.request
 */

package com.xeng.identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
