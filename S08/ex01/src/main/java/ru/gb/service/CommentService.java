package ru.gb.service;

import org.springframework.stereotype.Component;
import ru.gb.aspect.ToLog;
import ru.gb.model.Comment;

@Component
public class CommentService {
    @ToLog
    public String publish(Comment comment) {
        System.out.println("Publish comment by " + comment.getAuthor()
                + ": " + comment.getText());
        return "SUCCESS";
    }
}
