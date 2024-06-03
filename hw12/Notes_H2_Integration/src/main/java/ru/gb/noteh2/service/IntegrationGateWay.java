package ru.gb.noteh2.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ru.gb.noteh2.model.Note;

@MessagingGateway(defaultRequestChannel = "inputChannel")
public interface IntegrationGateWay {
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, Note note);
}
