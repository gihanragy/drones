package com.musula.backend.util;

import com.musula.backend.constant.AppConstants;
import com.musula.backend.util.exception.ServiceException;
import com.musula.backend.util.model.FieldErrorDTO;
import com.musula.backend.util.model.ValidationErrorDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Locale;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestErrorHandler {

    private static final String ERRORS_PREFIX = "errors.";
    private final MessageSource messageSource;

    @Autowired
    public RestErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<?> handleGeneralException(Exception exception) {
        ServiceResponse serviceResponse = ServiceResponse.builder()
                .details(exception.getMessage())
                .code(AppConstants.GENERAL_ERROR_CODE)
                .build();
        return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> processValidationError(BindException ex) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> objectErrors = result.getAllErrors();
        ServiceResponse serviceResponse = ServiceResponse.builder()
                .validationErrorDTO(processObjectErrors(objectErrors))
                .build();
        return ResponseEntity.badRequest().body(serviceResponse);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> objectErrors = result.getAllErrors();
        ServiceResponse serviceResponse = ServiceResponse.builder()
                .validationErrorDTO(processObjectErrors(objectErrors))
                .build();
        return ResponseEntity.badRequest().body(serviceResponse);
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<?> handleException(HttpClientErrorException exception) {
        String code;
        String detail = exception.getMessage();
        HttpStatus httpStatus = exception.getStatusCode();
        switch (exception.getStatusCode()) {
            case NOT_FOUND:
                code = AppConstants.GENERAL_ERROR_CODE_NOT_FOUND;
                break;
            case BAD_REQUEST:
                code = AppConstants.GENERAL_ERROR_CODE_BAD_REQUEST;
                break;

            case UNAUTHORIZED:
                code = AppConstants.GENERAL_ERROR_CODE_NOT_AUTHORIZED;
                break;
            case FORBIDDEN:
                code = AppConstants.GENERAL_ERROR_CODE_FORBIDEN;
                break;
            default:
                code = AppConstants.GENERAL_ERROR_CODE;
                break;
        }
        ServiceResponse serviceResponse = ServiceResponse.builder()
                .details(detail)
                .code(code)
                .build();
        return new ResponseEntity<>(serviceResponse, httpStatus);
    }

    @ExceptionHandler(value = {ResourceAccessException.class})
    @ResponseBody
    public ResponseEntity<?> handleException(ResourceAccessException exception) {
        String code = AppConstants.CONNECTION_REFUSED_ERROR_CODE;
        String detail = resolveLocalizedErrorMessage(code, exception.getMessage());

        ServiceResponse serviceResponse = ServiceResponse.builder()
                .details(detail)
                .code(code)
                .build();
        return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public ResponseEntity<?> processServiceException(ServiceException ex) {
        String localizedMessage = resolveLocalizedErrorMessage(ex.getCode(), ex.getArguments());
        ServiceResponse serviceResponse = ServiceResponse.builder()
                .details(ObjectUtils.isEmpty(localizedMessage) ? ex.getMessage() : localizedMessage)
                .code(ex.getCode())
                .build();
        return new ResponseEntity<>(serviceResponse, ex.getStatus());
    }


    private ValidationErrorDTO processObjectErrors(List<ObjectError> objectErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();
        objectErrors.forEach(objectError -> {
            String localizedErrorMessage = resolveLocalizedErrorMessage(objectError.getDefaultMessage());
            String field = ((FieldError) objectError).getField();
            Object rejectedValue = ((FieldError) objectError).getRejectedValue();

            FieldErrorDTO objectFieldError = FieldErrorDTO.builder()
                    .field(field)
                    .message(localizedErrorMessage)
                    .code(objectError.getDefaultMessage())
                    .rejectedValue(rejectedValue).build();
            dto.addFieldError(objectFieldError);
        });
        return dto;
    }

    public String resolveLocalizedErrorMessage(String code, Object... args) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String key = ERRORS_PREFIX + code;
        String localizedMessage = messageSource.getMessage(key, null, "", currentLocale);
        return String.format(localizedMessage != null ? localizedMessage : "", args);
    }
}
