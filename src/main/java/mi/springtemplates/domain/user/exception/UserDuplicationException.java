package mi.springtemplates.domain.user.exception;

import mi.springtemplates.global.enums.ErrorCode;
import mi.springtemplates.global.exception.GlobalException;

public class UserDuplicationException extends GlobalException {
    public UserDuplicationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
