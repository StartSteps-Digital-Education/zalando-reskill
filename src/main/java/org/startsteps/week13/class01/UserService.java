package org.startsteps.week13.class01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    private static final Map<Integer, User> userMap = new ConcurrentHashMap<>();
    private static final AtomicInteger idCounter = new AtomicInteger();

    public static User createUser(User user) {
        int userId = idCounter.incrementAndGet();
        user.setId(userId);
        userMap.put(userId, user);
        return user;
    }

    public static User getUser(int id) {
        return userMap.get(id);
    }

}

