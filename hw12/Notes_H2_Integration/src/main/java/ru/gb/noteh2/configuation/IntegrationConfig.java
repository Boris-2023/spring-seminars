package ru.gb.noteh2.configuation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import ru.gb.noteh2.model.Note;

import java.io.File;

@Configuration
public class IntegrationConfig {

    // channel to pass data to transformer
    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    // channel from transformed to save file
    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    // transformer block
    @Bean
    @Transformer(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public GenericTransformer<Note, String> transformNote() {
        return note -> "title = " + note.getTitle().toUpperCase()
                + ", description = " + note.getDescription();
    }

    // terminal block - save to file
    @Bean
    @ServiceActivator(inputChannel = "outputChannel")
    public FileWritingMessageHandler outHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("notes_log"));

        handler.setExpectReply(false);
        handler.setAutoCreateDirectory(true);
        handler.setCharset("utf8");
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
