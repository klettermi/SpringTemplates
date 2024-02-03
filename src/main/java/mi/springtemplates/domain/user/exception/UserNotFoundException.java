package mi.springtemplates.domain.user.exception;

import mi.springtemplates.global.enums.ErrorCode;
import mi.springtemplates.global.exception.GlobalException;

public class UserNotFoundException extends GlobalException {
    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}