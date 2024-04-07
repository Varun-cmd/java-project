package org.example.rest;

import org.example.rest.controller.userDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class userResource {
    private userDaoService service;
    public userResource(userDaoService service){
        this.service=service;
    }


    @GetMapping(path ="/users")
    public List<user> getAllUsers(){
        return service.findAll();
    }
    @GetMapping(path ="/users/{id}")
    public user getAllUsers(@PathVariable int id){
        user user=  service.findOne(id);
        if (user==null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }


    @PostMapping("/users")
    public ResponseEntity<user> createUser(@RequestBody user user){
        user u = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()   // Get the base URI
                .path("/users/{id}")       // Append the correct path format
                .buildAndExpand(u.getId()) // Expand the URI template with the user ID
                .toUri();
        return ResponseEntity.created(location).build();
    }

//    @PostMapping("/users")
//    public void createUser(@RequestBody user user){
//        service.save(user);
//    }
//


}
