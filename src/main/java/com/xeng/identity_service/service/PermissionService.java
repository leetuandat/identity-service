package com.xeng.identity_service.service;

import com.xeng.identity_service.dto.request.PermissionRequest;
import com.xeng.identity_service.dto.response.PermissionResponse;
import com.xeng.identity_service.entity.Permission;
import com.xeng.identity_service.mapper.PermissionMapper;
import com.xeng.identity_service.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 12-Apr-26
 * @time: 05:58 PM
 * @package: com.xeng.identity_service.service
 */

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
