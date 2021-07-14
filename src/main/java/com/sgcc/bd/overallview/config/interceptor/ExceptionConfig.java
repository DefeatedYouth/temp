package com.sgcc.bd.overallview.config.interceptor;

import com.sgcc.bd.overallview.common.exception.XbootException;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/15
 * @desc
 */
@ControllerAdvice
@Slf4j
public class ExceptionConfig {


//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result exceptionHandler(Exception e) {
//        log.error("error ==>",e);
//        return ResultUtil.error(500,"系统开小差了，请稍后再试");
//    }

    @ExceptionHandler(XbootException.class)
    @ResponseBody
    public Result exceptionHandler(XbootException e) {
        return ResultUtil.error(500,e.getMsg());
    }

    /**
     * 入参参数校验
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Result argsNotValidExceptionHandle(MethodArgumentNotValidException e, HttpServletRequest request) {
        try {
            List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
            String message = fieldErrors.stream().map(s ->"<" + s.getField() + ">" +s.getDefaultMessage()).collect(Collectors.joining(";"));
            log.debug("接口：【{}】;参数校验不通过 ==>【{}】",request.getServletPath(), message);
            return  ResultUtil.error(500, message);
        } catch (Exception exception){
            log.error("接口：【{}】;参数校验不通过 ",request.getServletPath());
            return ResultUtil.error(500, "参数校验不通过");
        }
    }
}
