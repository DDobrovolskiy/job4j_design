package ru.job4j.collection.ex;

import java.util.*;

public class UserEmail {

    public Map<String, List<String>> mergeUsersOnEmail(Map<String, List<String>> users) {
        Map<String, List<String>> mergeUsers = new HashMap<>(users.size());
        Node nodes = null;
        for (Map.Entry<String, List<String>> user : users.entrySet()) {
            if (nodes == null) {
                nodes = new Node(user.getKey(), user.getValue());
            } else {
                nodes.merge(user.getKey(), user.getValue());
            }
        }
        while (nodes != null) {
            mergeUsers.put(nodes.nameNode, new ArrayList<>(nodes.emailsNode));
            nodes = nodes.nextNode;
        }
        return mergeUsers;
    }

    private static class Node {
        private String nameNode;
        private Set<String> emailsNode;
        private Node nextNode;

        public Node(String name, Collection<String> emails) {
            this.nameNode = name;
            this.emailsNode = new HashSet<>(emails);
        }

        public void merge(String name, Collection<String> emails) {
            if (containsAny(emails)) {
                this.emailsNode.addAll(emails);
            } else {
                if (nextNode == null) {
                    nextNode = new Node(name, emails);
                } else {
                    nextNode.merge(name, emails);
                }
            }
        }

        private boolean containsAny(Collection<String> emails) {
            for (String email : emails) {
                if (this.emailsNode.contains(email)) {
                    return true;
                }
            }
            return false;
        }
    }
}
