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
        pattern = Pattern.compile("(^\\.{2})?(^(\\/)|(\\/))*(\\w+)*");
    }

    public void cd(String path) {
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            System.out.println(matcher.group(5));
            if (matcher.group(1) != null) {
                paths.clear();
            }
            if (matcher.group(3) != null) {
                paths.clear();
            }
            if (matcher.group(5) != null) {
                paths.add(matcher.group(5));
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
