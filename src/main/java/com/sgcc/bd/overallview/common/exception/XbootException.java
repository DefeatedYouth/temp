package com.sgcc.bd.overallview.common.exception;

import lombok.Data;

/**
 * @author Exrickx
 */
@Data
public class XbootException extends RuntimeException {

    private String msg;

    public XbootException(String msg){
        super(msg);
        this.msg = msg;
    }

    public XbootException(String msgFormat,String... args){
        String msg = String.format(msgFormat, args);
        this.msg = msg;
    }
}
