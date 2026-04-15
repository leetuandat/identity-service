package com.xeng.identity_service.enums;

import java.security.Permission;

public enum Role {
    ADMIN,
    STAFF, // updatePost, approvePost
    USER
}

/**
 * User -> many Role
 *         Role -> many Permission
 */