package com.xeng.identity_service.repository;

import com.xeng.identity_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 15-Apr-26
 * @time: 05:33 PM
 * @package: com.xeng.identity_service.repository
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
