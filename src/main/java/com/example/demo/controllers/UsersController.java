package com.example.demo.controllers;


import com.example.demo.entities.users;
import com.example.demo.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@Api(tags = "Users", value = "Web Service RESTFul of Users")
public class UsersController {

    private final IUserService usersService;
    public UsersController(IUserService usersService) {
        this.usersService = usersService;
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<users>> findAllUsers(){
        try {
            List<users> users = usersService.getAll();
            if(users.size()>0)
                return new ResponseEntity<>(users, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<users> insertUser( @RequestBody users user){
        try{
            users newUser = usersService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<users> updateUsers(@PathVariable("id") Long id, @RequestBody users users){
        try{
            if(id.equals(users.getId())){
                users usersUp = usersService.save(users);
                if(usersUp != null)
                    return new ResponseEntity<>(usersUp, HttpStatus.OK);
                else
                    return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<users> deleteUsers(@PathVariable("id") Long id){
        try{
            usersService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<users> findUsersById(@PathVariable("id") Long id){
        try{
            users users = usersService.getById(id);
            if(users != null)
                return new ResponseEntity<>(users, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<users> findUsersByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        try{
            users users = usersService.findByEmailAndPassword(email, password);
            if(users != null)
                return new ResponseEntity<>(users, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
