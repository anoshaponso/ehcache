package com.example.cache.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@RequiredArgsConstructor
@ToString
@Data
public class Person implements Serializable {
    private Long id;
    private String name;
    private String nic;
}
