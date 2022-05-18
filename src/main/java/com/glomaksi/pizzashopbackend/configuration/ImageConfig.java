package com.glomaksi.pizzashopbackend.configuration;

import com.uploadcare.api.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageConfig {
    @Value("#{environment.PRIVATE_KEY}")
    private String privateKey;
    @Value("#{environment.PUBLIC_KEY}")
    private String publicKey;
    @Bean
    public Client getClient() {
        return new Client(publicKey, privateKey);
    }
}
