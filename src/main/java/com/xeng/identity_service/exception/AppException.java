/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 2/24/2025
 * @time: 02:31 PM
 * @package: com.xeng.identity_service.exception
 */

package com.xeng.identity_service.exception;

public class AppException extends RuntimeException {

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
