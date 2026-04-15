package com.xeng.identity_service.service;

import com.xeng.identity_service.dto.request.RoleRequest;
import com.xeng.identity_service.dto.response.RoleResponse;
import com.xeng.identity_service.mapper.RoleMapper;
import com.xeng.identity_service.repository.PermissionRepository;
import com.xeng.identity_service.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 15-Apr-26
 * @time: 05:34 PM
 * @package: com.xeng.identity_service.service
 */

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        var roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
