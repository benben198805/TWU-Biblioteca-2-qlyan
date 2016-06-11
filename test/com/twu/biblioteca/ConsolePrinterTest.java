package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by ben on 16-6-12.
 */
public class ConsolePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintContentToOutputStreamWhenIWantToPrintIt() {
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("print me to console");

        assertEquals(outContent.toString(), "print me to console");
    }




    @Test
    public void shouldCanPrintSpecialCharacter() {
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("@#$%^&*\n");
        assertEquals(outContent.toString(), "@#$%^&*\n");
    }

}