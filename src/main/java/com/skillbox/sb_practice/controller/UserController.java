package com.skillbox.sb_practice.controller;

import com.skillbox.sb_practice.dto.CommonUpsertResponse;
import com.skillbox.sb_practice.dto.UserCreateRequest;
import com.skillbox.sb_practice.dto.UserResponse;
import com.skillbox.sb_practice.dto.UserUpdateRequest;
import com.skillbox.sb_practice.service.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServiceImpl userService;

    //create
    @PostMapping
    public ResponseEntity<CommonUpsertResponse> create(@RequestBody @Valid UserCreateRequest userCreateRequest){
        var response = userService.save(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<CommonUpsertResponse> update(@PathVariable Long id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        userService.update(id, userUpdateRequest);
        return ResponseEntity.noContent().build();
    }
    //delete

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonUpsertResponse> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    //getAll

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(@PathParam("size") Integer size, @PathParam("page") Integer page) {
        return ResponseEntity.ok(userService.getAllByPage(page, size));
    }
}
