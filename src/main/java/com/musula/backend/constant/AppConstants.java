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


    public static final String SERIAL_LENGTH_MIN_MAX = "1006";
    public static final String WEIGHT_RANGE_ERROR_MESSAGE = "1007";
    public static final String DRONE_MODEL_VALUE = "1008";
    public static final String STATE_NOT_VALID = "1009";
    public static final String SERIAL_NUMBER_ALREAY_REGISTERED = "1010";


    /**
     * To avoid creating instance of AppConstants class.
     */
    private AppConstants() {
        throw new IllegalStateException("AppConstants class are not meant to be instantiated.");
    }


}