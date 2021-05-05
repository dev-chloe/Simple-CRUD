package com.toyproject.simplecrudapp.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class RootController {

  @GetMapping("/")
  public String index() {
    try {
      InetAddress address = InetAddress.getLocalHost();
      return String.format( "Respond from a pod %s (%s)", address.getHostName(), address.getHostAddress() );
    } catch ( Exception e ) {
      e.printStackTrace();
      return String.format( "Error: %s", e.toString() );
    }
  }

  @GetMapping("/health-check")
  public ResponseEntity<?> healthCheck() { // https://www.baeldung.com/spring-response-entity
    return ResponseEntity.ok("SpringBoot API is now ready!");
  }

}
