/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 2/18/2025
 * @time: 02:00 PM
 * @package: com.xeng.identity_service.controller
 */

package com.xeng.identity_service.controller;

import com.xeng.identity_service.dto.request.ApiResponse;
import com.xeng.identity_service.dto.request.UserCreationRequest;
import com.xeng.identity_service.dto.request.UserUpdateRequest;
import com.xeng.identity_service.dto.response.UserResponse;
import com.xeng.identity_service.entity.User;
import com.xeng.identity_service.service.UserService;
import java.util.*;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {

    UserService userService;

    @GetMapping("/hello")
    ApiResponse<String> sayHello() {
        ApiResponse<String> response = new ApiResponse<>();
        response.setResult("Xin chào!");
        response.setMessage("Ok");
        return response;
    }

    @PostMapping()
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {

        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping()
    ApiResponse<List<UserResponse>> getUsers() {
//        ApiResponse<List<User>> response = new ApiResponse<>();
//        response.setResult(userService.getUsers());
//        response.setMessage("Lấy danh sách thành công");
//        return response;
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
//        ApiResponse<UserResponse> response = new ApiResponse<>();
//        response.setResult(userService.getUser(userId));
//        response.setMessage("Lay thong tin nguoi dung thanh cong!");
//        return response;
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    //get by token
    @GetMapping("/myinfo")
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
//        ApiResponse<UserResponse> response = new ApiResponse<>();
//        response.setResult(userService.updateUser(userId, request));
//        response.setMessage("Cập nhật người dùng thành công!");
//        return response;
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
//        ApiResponse<String> response = new ApiResponse<>();
//        response.setResult("Người dùng đã xóa");
//        response.setMessage("Xóa thành công!");
//        return response;
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }
}
