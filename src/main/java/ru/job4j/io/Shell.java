package ru.job4j.io;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shell {
    private Stack<String> paths;
    private Pattern pattern;
    private Matcher matcher;

    public Shell() {
        paths = new Stack<>();
        pattern = Pattern.compile("(\\/)*(\\w+)*");
    }

    public void cd(String path) {
        if ((path.startsWith("..")) || (path.startsWith("/"))) {
            paths.clear();
        }
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            System.out.println(matcher.group(2));
            if (matcher.group(2) != null) {
                paths.add(matcher.group(2));
            }
        }
    }

    public String pwd() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(paths.isEmpty());
        paths.forEach(s -> stringBuilder.append("/" + s));
        return paths.isEmpty() ? "/" : stringBuilder.toString();
    }
}
