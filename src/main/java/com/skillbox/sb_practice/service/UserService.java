package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.CommonUpsertResponse;
import com.skillbox.sb_practice.dto.UserCreateRequest;
import com.skillbox.sb_practice.dto.UserResponse;
import com.skillbox.sb_practice.dto.UserUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    CommonUpsertResponse save(UserCreateRequest createRequest);
    void delete(long id);
    CommonUpsertResponse update(Long id, UserUpdateRequest userUpdateRequest);
    UserResponse getById(Long id);
    List<UserResponse> getAllByPage(int page, int size);
}
