package com.microservicos.gabriel.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
public class SecurityXmlConfig {

 public SecurityXmlConfig() {
     super();
}
 
} 