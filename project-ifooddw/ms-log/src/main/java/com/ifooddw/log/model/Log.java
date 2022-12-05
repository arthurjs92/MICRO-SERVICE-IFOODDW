package com.ifooddw.log.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("log")
public class Log<T> {
    @Id
    private String id;
    private Action action = Action.NONE;
    private Date date = new Date();
    private Object object = new Object();

    public Log(T object) {
        this.object = object;
    }
}
