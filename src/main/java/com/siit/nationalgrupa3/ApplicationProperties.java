package com.siit.nationalgrupa3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("national.grupa3.rest")
@Getter
@Setter
public class ApplicationProperties {

    private String library;
    private String bookName;

}
