package org.example.rest.controller;

import org.example.rest.user;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class userDaoService {

    // get all users , save new users, get unique user


    private static int userCount=0;
    private  static List<user> users = new ArrayList<>();


    static{
        users.add(new user(++userCount,"varun", LocalDate.now().minusYears(30)));
        users.add(new user(++userCount,"Alex", LocalDate.now().minusYears(78)));
        users.add(new user(++userCount,"Marc", LocalDate.now().minusYears(25)));
        users.add(new user(++userCount,"Julius", LocalDate.now().minusYears(44)));

    }

    public List<user> findAll(){

        return users;
    }
    public user findOne(int id) {
        Predicate<? super user> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public user save(user user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }



}
