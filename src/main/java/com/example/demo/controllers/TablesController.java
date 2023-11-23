package com.example.demo.controllers;

import com.example.demo.entities.Tables;
import com.example.demo.entities.users;
import com.example.demo.service.IUserService;
import com.example.demo.service.ItablesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tables")
public class TablesController {
    private final ItablesService tablesService;
    private final IUserService usersService;
    public TablesController(ItablesService tablesService, IUserService usersService) {
        this.tablesService = tablesService;
        this.usersService = usersService;
    }

    @GetMapping("")
    public ResponseEntity<List<Tables>> findAllTables(){
        try {
            List<Tables> tables = tablesService.getAll();
            if(tables.size()>0)
                return new ResponseEntity<>(tables, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tables> findTableById(@PathVariable("id") Long id){
        try{
            Tables table = tablesService.getById(id);
            if(table != null)
                return new ResponseEntity<>(table, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tables> deleteTable(@PathVariable("id") Long id){
        try{
            Tables tableDelete = tablesService.getById(id);
            if(tableDelete != null){
                tablesService.delete(id);
                return new ResponseEntity<>(tableDelete, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/{User_id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tables> createTable( @PathVariable("User_id")Long User_id,@RequestBody Tables table){
        try{
            users user = usersService.getById(User_id);
            table.setId_user(user);
            Tables tableCreate = tablesService.save(table);
            return ResponseEntity.status(HttpStatus.CREATED).body(tableCreate);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
