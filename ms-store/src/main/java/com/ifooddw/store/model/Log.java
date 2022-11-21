package com.ifooddw.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log<T> {

    private Action action = Action.NONE;
    private Date date;
    private Object object = new Object();

    public Log(T object) {
        this.object = object;
    }
}
