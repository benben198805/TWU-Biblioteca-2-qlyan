package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ConsolePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_content_to_output_stream_when_want_to_print_it() {
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("print me to console");

        assertEquals(outContent.toString(), "print me to console\n");
    }

    @Test
    public void should_can_print_special_character() {
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("@#$%^&*");
        assertEquals(outContent.toString(), "@#$%^&*\n");
    }

}