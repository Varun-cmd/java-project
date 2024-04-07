package org.example.rest;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class hello {

    String message;

    public hello() {
    }

    public hello(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "hello{" +
                "message='" + message + '\'' +
                '}';
    }
}
