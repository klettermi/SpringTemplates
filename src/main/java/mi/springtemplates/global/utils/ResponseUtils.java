package mi.springtemplates.global.utils;

import mi.springtemplates.global.enums.ErrorCode;
import mi.springtemplates.global.enums.SuccessCode;
import mi.springtemplates.global.responseDto.ApiResponse;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ResponseUtils {

    public static <T> ApiResponse<T> ok(T response) {
        return new ApiResponse<>(true, 200, null, response, null);
    }

    public static ApiResponse<?> ok(SuccessCode successCode) {
        int statusCode = successCode.getHttpStatus().value();
        String msg = successCode.getDetail();
        return new ApiResponse<>(true, statusCode, msg, null, null);
    }

    public static <T> ApiResponse<?> ok(SuccessCode successCode, T response) {
        int statusCode = successCode.getHttpStatus().value();
        String msg = successCode.getDetail();
        return new ApiResponse<>(true, statusCode, msg, response, null);
    }

    public static ApiResponse<?> error(ErrorCode errorCode) {
        int statusCode = errorCode.getHttpStatus().value();
        String msg = errorCode.getDetail();
        return new ApiResponse<>(false, statusCode, msg, null, null);
    }

    public static ApiResponse<?> error(HttpStatus httpStatus, Map<String, String> errors) {
        return new ApiResponse<>(false, httpStatus.value(), null, null, errors);
    }

    public static <T> ApiResponse<?> error(T response) {
        return new ApiResponse<>(false, 500, null, response, null);
    }
}
