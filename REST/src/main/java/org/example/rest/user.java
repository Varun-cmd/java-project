package org.example.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class user {
    private Integer id;
    private String name;
    private LocalDate birthDate;
}
