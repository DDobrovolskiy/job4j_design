package ru.job4j.io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    private List<String> answers;
    private List<String> messages;
    private Random random;
    private boolean isStop = false;
    private boolean isOut = false;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.random = new Random();
        this.messages = new LinkedList<>();
    }

    public void run() {
        readBotAnswers();
        Scanner chat = new Scanner(System.in);
        printMessage("Общение с ботом:");
        while (!isOut) {
            peopleSay(chat.nextLine());
            getAnswer();
        }
        chat.close();
        writeMessages();
    }

    private void peopleSay(String message) {
        if (CONTINUE.equals(message)) {
            isStop = false;
        } else if (STOP.equals(message)) {
            isStop = true;
        } else if (OUT.equals(message)) {
            isStop = true;
            isOut = true;
        }
        logger(message);
    }

    private String logger(String message) {
        messages.add(message);
        return message;
    }

    private void writeMessages() {
        try (BufferedWriter log = new BufferedWriter(new FileWriter(path))) {
            for (String message : messages) {
                log.write(message + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printMessage(String message) {
        System.out.println(logger(message));
    }

    private void readBotAnswers() {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            answers = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAnswer() {
        if (!isStop) {
            printMessage("bot: " + searchAnswer());
        }
    }

    private String searchAnswer() {
        return answers.get(random.nextInt(answers.size() - 1));
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "./data/ChatLogger.txt",
                "./data/AnswerBot.txt");
        cc.run();
    }

}
