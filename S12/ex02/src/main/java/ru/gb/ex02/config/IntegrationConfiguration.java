package ru.gb.ex02.config;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.feed.dsl.Feed;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.AbstractPayloadTransformer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class IntegrationConfiguration {

    @Bean
    public IntegrationFlow feedFlow() throws MalformedURLException {
        return IntegrationFlow
                .from(Feed.inboundAdapter(new URL("https://lenta.ru/rss"), "news"), e -> e.poller(p -> p.fixedDelay(5000)))
                .transform(extractor())
                .handle(myHandler())
                .get();
    }

    @Bean
    public AbstractPayloadTransformer<SyndEntry, String> extractor() {
        return new AbstractPayloadTransformer<SyndEntry, String>() {
            @Override
            protected String transformPayload(SyndEntry payload) {
                return payload.getTitle() + " -> "
                        + payload.getAuthor() + " -> "
                        + payload.getLink() + ";";
            }
        };
    }

    @Bean
    public FileWritingMessageHandler myHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("./RSS"));

        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND); // дописываем
        handler.setAppendNewLine(true); // добавлять строки
        handler.setAutoCreateDirectory(true);
        handler.setCharset("utf8");

        return handler;
    }
}
