package cn.edu.nbpt.lilingyi.blogmanage.exception;


import cn.edu.nbpt.lilingyi.blogmanage.Result;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.enums.ErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class GloballExceptionHandler {

    @ExceptionHandler(BizException.class)
    Result handleException(BizException e){
        e.printStackTrace();
        return Result.error(e.getMsg());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    Result handleIllegalArgumentBizException(Exception e){
        e.printStackTrace();
        return Result.error(ErrorCode.PARAMS_ERROR.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    Result handleException(Exception e){
        e.printStackTrace();
        return Result.error(ErrorCode.ERROR.getCode(),ErrorCode.ERROR.getMsg());
    }
}
