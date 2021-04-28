package ru.job4j.collection.ex;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserEmailTest {

    @Test
    public void mergeUsersOnEmail() {
        Map<String, List<String>> users = new HashMap<>();

        users.put("user1", List.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        users.put("user2", List.of("foo@gmail.com", "ups@pisem.net"));
        users.put("user3", List.of("xyz@pisem.net", "vasya@pupkin.com"));
        users.put("user4", List.of("ups@pisem.net", "aaa@bbb.ru"));
        users.put("user5", List.of("xyz@pisem.net"));

        UserEmail userEmail = new UserEmail();
        Map<String, List<String>> actual = userEmail.mergeUsersOnEmail(users);

        for (Map.Entry<String, List<String>> item : actual.entrySet()) {
            if (Set.of("user1", "user2", "user4").contains(item.getKey())) {
                Assert.assertTrue(
                        Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru")
                                .containsAll(item.getValue()));
                continue;
            }
            if (Set.of("user3", "user5").contains(item.getKey())) {
                Assert.assertTrue(
                        Set.of("xyz@pisem.net", "vasya@pupkin.com")
                                .containsAll(item.getValue()));
                continue;
            }
            Assert.assertTrue(false);
        }
    }
}