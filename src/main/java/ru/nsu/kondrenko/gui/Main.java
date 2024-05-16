package ru.nsu.kondrenko.gui;

import ru.nsu.kondrenko.model.dto.Patient;

import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("llirik42", Date.from(Instant.now()));
        System.out.println(patient);
    }
}