/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 9/4/2025
 * @time: 03:20 PM
 * @package: com.xeng.identity_service.controller
 */

package com.xeng.identity_service.controller;

import com.nimbusds.jose.JOSEException;
import com.xeng.identity_service.dto.request.ApiResponse;
import com.xeng.identity_service.dto.request.AuthenticationRequest;
import com.xeng.identity_service.dto.request.IntrospectRequest;
import com.xeng.identity_service.dto.response.AuthenticationResponse;
import com.xeng.identity_service.dto.response.IntrospectResponse;
import com.xeng.identity_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .message("Dang nhap thanh cong")
                .timestamp(LocalDateTime.now())
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
