/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 2/18/2025
 * @time: 01:56 PM
 * @package: com.xeng.identity_service.dto.request
 */

package com.xeng.identity_service.dto.request;

import com.xeng.identity_service.exception.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, max = 20, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
