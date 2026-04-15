package com.xeng.identity_service.controller;

import com.xeng.identity_service.dto.request.ApiResponse;
import com.xeng.identity_service.dto.request.RoleRequest;
import com.xeng.identity_service.dto.response.PermissionResponse;
import com.xeng.identity_service.dto.response.RoleResponse;
import com.xeng.identity_service.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 15-Apr-26
 * @time: 04:56 PM
 * @package: com.xeng.identity_service.controller
 */
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
   RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder()
                .build();
    }
}
