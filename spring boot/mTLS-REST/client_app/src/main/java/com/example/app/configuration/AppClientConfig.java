package com.example.app.configuration;

import feign.Retryer;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.FormEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
@RequiredArgsConstructor
public class AppClientConfig {

    @Value("${feign.server-api.period}")
    private int period;

    @Value("${feign.server-api.duration}")
    private int duration;

    @Value("${feign.server-api.retryAttempts}")
    private int retryAttempts;

    private final ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Primary
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    Encoder feignFormEncoder() {
        return new FormEncoder(new SpringEncoder(this.messageConverters));
    }

    @Bean
    Retryer retryer() {
        return new Retryer.Default(period, SECONDS.toMillis(duration), retryAttempts);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientErrorDecoder();
    }

}
