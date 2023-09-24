package ru.panyukovnn.telegramsingleresponsibility.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "bot")
public class TLBotProperties {

    private String name;
    private String token;
}
