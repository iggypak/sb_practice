package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.comments.CommonUpsertResponse;
import com.skillbox.sb_practice.dto.users.UserCreateRequest;
import com.skillbox.sb_practice.dto.users.UserResponse;
import com.skillbox.sb_practice.dto.users.UserUpdateRequest;

import java.util.List;

public interface UserService {
    CommonUpsertResponse save(UserCreateRequest createRequest);
    void delete(long id);
    CommonUpsertResponse update(Long id, UserUpdateRequest userUpdateRequest);
    UserResponse getById(Long id);
    List<UserResponse> getAllByPage(int page, int size);
}
