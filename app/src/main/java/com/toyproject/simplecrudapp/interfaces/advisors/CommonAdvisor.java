package com.toyproject.simplecrudapp.interfaces.advisors;

import com.toyproject.simplecrudapp.utils.fixed.Res;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CommonAdvisor {

  /**
   * Handle BindException when occur Field error in Request DTO Object.
   */
  @ExceptionHandler( BindException.class )
  @ResponseStatus( HttpStatus.BAD_REQUEST ) // 400
  @ResponseBody
  public Map<String, Object> handleInvalidBindEachDTO(BindException e) {
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put( Res.K.Cause, "invalid parameter");
    jsonMap.put( Res.K.Detail, e.getFieldError().getDefaultMessage());
    return jsonMap;
  }

}
