package com.toyproject.simplecrudapp.supports;

import com.toyproject.simplecrudapp.SimpleCrudApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith( SpringExtension.class )
@SpringBootTest( classes = SimpleCrudApplication.class )
@ActiveProfiles( "test" )
public interface SpringTestSupport {
}
