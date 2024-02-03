package mi.springtemplates.global.exception;

import lombok.Getter;
import mi.springtemplates.global.enums.ErrorCode;

@Getter
public class GlobalException extends RuntimeException {

    private final ErrorCode errorCode;

    public GlobalException(ErrorCode errorCode) {
        super(errorCode.getDetail());
        this.errorCode = errorCode;
    }
}
