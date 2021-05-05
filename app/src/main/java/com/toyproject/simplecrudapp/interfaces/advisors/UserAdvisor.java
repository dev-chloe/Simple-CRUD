package com.toyproject.simplecrudapp.interfaces.advisors;

import com.toyproject.simplecrudapp.interfaces.exceptions.UserResException;
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
  @ExceptionHandler( UserResException.class )
  @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR ) // 500
  @ResponseBody
  public Map<String, Object> handleRuntimeException(UserResException e) {
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put( Res.K.Cause, "internal error");
    jsonMap.put( Res.K.Detail, e.getMessage());
    return jsonMap;
  }
}
