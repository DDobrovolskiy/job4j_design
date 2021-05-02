package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void unavailable() {
        String source = "./data/server.log";
        String target = "./data/serverOutdoor.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);

        List<String> action = new LinkedList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(action::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> exception = new LinkedList<>();
        exception.add("10:57:01;10:59:01;");
        exception.add("11:01:02;11:02:02;");

        assertThat(action, is(exception));
    }
}