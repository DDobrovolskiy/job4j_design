package ru.job4j.io.ex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Find {

    private static Predicate<Path> predicate(String mask, String name) throws IllegalAccessException {
        if (mask.equals("mask")) {
            return path -> path.toFile().getName().contains(name);
        } else if (mask.equals("name")) {
            return path -> path.toFile().getName().equals(name);
        } else if (mask.equals("regex")) {
            return path -> path.toFile().getName().matches(name);
        }
        throw new IllegalAccessException("Выбранная маска не является mask/name/regex");
    }

    public static void main(String[] args) {
        Arguments arguments = Arguments.of(args);
        try (PrintWriter out = new PrintWriter(new FileOutputStream(arguments.get("o")))) {
            List<Path> paths = CoreSearch.search(new File(arguments.get("d")).toPath(),
                    predicate(arguments.get("t"), arguments.get("n")));
            for (Path path : paths) {
                System.out.println(path.normalize());
                out.println(path.normalize().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
