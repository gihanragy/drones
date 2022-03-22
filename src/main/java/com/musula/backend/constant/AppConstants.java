package com.musula.backend.constant;


/**
 * The Class AppConstants.
 */
public final class AppConstants {


    public static final String GENERAL_ERROR_CODE = "1000";
    public static final String GENERAL_ERROR_CODE_NOT_FOUND = "1001";
    public static final String GENERAL_ERROR_CODE_BAD_REQUEST = "1002";
    public static final String GENERAL_ERROR_CODE_NOT_AUTHORIZED = "1003";
    public static final String GENERAL_ERROR_CODE_FORBIDEN = "1004";
    public static final String CONNECTION_REFUSED_ERROR_CODE = "1005";


    public static final String TYPE_NOT_FOUND = "1001";


    /**
     * To avoid creating instance of AppConstants class.
     */
    private AppConstants() {
        throw new IllegalStateException("AppConstants class are not meant to be instantiated.");
    }


}