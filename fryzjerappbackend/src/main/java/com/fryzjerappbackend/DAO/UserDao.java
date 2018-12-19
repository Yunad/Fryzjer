package com.fryzjerappbackend.DAO;

import com.fryzjerappbackend.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserDao implements Dao<User> {
    private List<User> userList = new ArrayList<>();

    @Override
    public Optional<User> get(int id) {
        return Optional.ofNullable(userList.get(id));
    }

    @Override
    public Collection<User> getAll() {
        return userList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public void update(User user) {
        userList.set(Math.toIntExact(user.getId()), user);
    }

    @Override
    public void delete(User user) {
        userList.set(Math.toIntExact(user.getId()), null);
    }
}
