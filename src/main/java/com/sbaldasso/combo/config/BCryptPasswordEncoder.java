package com.sbaldasso.combo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BCryptPasswordEncoder {
    @Bean
    public org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}
