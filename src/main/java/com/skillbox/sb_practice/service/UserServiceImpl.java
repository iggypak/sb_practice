package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.comments.CommonUpsertResponse;
import com.skillbox.sb_practice.dto.users.UserCreateRequest;
import com.skillbox.sb_practice.dto.users.UserResponse;
import com.skillbox.sb_practice.dto.users.UserUpdateRequest;
import com.skillbox.sb_practice.exceptions.EntityNotFoundException;
import com.skillbox.sb_practice.mapper.UserMapper;
import com.skillbox.sb_practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    private final UserRepository userRepository;


    @Override
    public CommonUpsertResponse save(UserCreateRequest userCreateRequest) {
        var user = userMapper.map(userCreateRequest);
        return userMapper.mapToCommon(userRepository.save(user));
    }
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public CommonUpsertResponse update(Long id, UserUpdateRequest updateRequest) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Entity with id " + id + " not found in update method");
                    throw new EntityNotFoundException("Id " + id + " not found");
                });
        userMapper.update(updateRequest, user);
        return userMapper.mapToCommon(user);
    }

    @Override
    public List<UserResponse> getAllByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var userList = userRepository.getUsersWithCounters(pageable).toList();
        return userMapper.map(userList);
    }

    @Override
    public UserResponse getById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> {
            log.error("Entity with id " + id + " not found in update method");
            throw new EntityNotFoundException("Id " + id + " not found");
        });
        return userMapper.map(user);
    }

}
