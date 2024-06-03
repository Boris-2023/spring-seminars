package ru.gb.tasks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class ConfigIntegration {
    @Bean
    public MessageChannel textInputChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriter(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWriter")
    public GenericTransformer<String, String> mainTransformer(){
        return text -> {
            text = text.toUpperCase();
            return text;
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriter")
    public FileWritingMessageHandler myHandler(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("."));

        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND); // дописываем
        handler.setAppendNewLine(true); // добавлять строки

        return handler;
    }
}
