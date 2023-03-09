package com.bjtu.common.handler;

import com.bjtu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result errorNull(Exception e) {
        e.printStackTrace();
        return Result.fail().message("执行了空指针异常处理");
    }

    @ExceptionHandler(BJTUException.class)
    @ResponseBody
    public Result errorBJTU(BJTUException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }
}
