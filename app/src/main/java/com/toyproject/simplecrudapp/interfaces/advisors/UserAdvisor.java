package com.toyproject.simplecrudapp.interfaces.advisors;

import com.toyproject.simplecrudapp.interfaces.exceptions.UserRequestException;
import com.toyproject.simplecrudapp.utils.fixed.Res;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserAdvisor {

  /**
   * Handle UserResException when occur Field error in Response DTO Object.
   */
  @ExceptionHandler( UserRequestException.class )
  @ResponseStatus( HttpStatus.BAD_REQUEST ) // 400
  @ResponseBody
  public Map<String, Object> handleRequestException( UserRequestException e ) {
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put( Res.K.Cause, "invalid parameter");
    jsonMap.put( Res.K.Detail, e.getMessage());
    return jsonMap;
  }

  /**
   * Handle UserResException when occur Field error in Response DTO Object.
   */
  @ExceptionHandler( Exception.class )
  @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR ) // 500
  @ResponseBody
  public Map<String, Object> handleInternalException( Exception e ) {
    e.printStackTrace();
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put( Res.K.Cause, "internal error");
    jsonMap.put( Res.K.Detail, e.getMessage());
    return jsonMap;
  }

}
