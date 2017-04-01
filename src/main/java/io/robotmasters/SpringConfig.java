package io.robotmasters;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jokerr
 */
@Configuration
@ComponentScan(basePackages = {
        "io.robotmasters.beans"
})
public class SpringConfig {

}
