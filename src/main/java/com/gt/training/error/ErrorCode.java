package com.gt.training.error;

/**
 * Created by WeiHang on 2020/02/22.
 */
public class ErrorCode {

    private ErrorCode(){}

    public static final String NORMAL = "200";
    private static final String ERROR_CODE_PREFIX = "training-";
    public static final String NOT_SINGLE_DIGITS = ERROR_CODE_PREFIX + "01";
    public static final String ZERO = ERROR_CODE_PREFIX + "02";
    public static final String FILE_FAIL = ERROR_CODE_PREFIX + "03";



}
