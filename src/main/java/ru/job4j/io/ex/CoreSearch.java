package ru.job4j.io.ex;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class CoreSearch {

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        CoreSearchFile searcher = new CoreSearchFile(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    static class CoreSearchFile extends SimpleFileVisitor<Path> {
        private Predicate<Path> condition;
        private List<Path> paths = new LinkedList<>();

        public List<Path> getPaths() {
            return paths;
        }

        public CoreSearchFile(Predicate<Path> condition) {
            this.condition = condition;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (condition.test(file)) {
                paths.add(file);
            }
            return super.visitFile(file, attrs);
        }
    }
}
