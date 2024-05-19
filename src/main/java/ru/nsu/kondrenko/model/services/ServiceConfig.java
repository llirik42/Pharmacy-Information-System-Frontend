package ru.nsu.kondrenko.model.services;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceConfig {
    private String address;

    private int port;
}
