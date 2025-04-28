package com.skillbox.sb_practice.mapper;

import com.skillbox.sb_practice.dto.UserCreateRequest;
import com.skillbox.sb_practice.dto.UserResponse;
import com.skillbox.sb_practice.dto.UserShortResponse;
import com.skillbox.sb_practice.dto.UserUpdateRequest;
import com.skillbox.sb_practice.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends CommonMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "countComments", source = "commentCounters.comments")
    @Mapping(target = "countNews", source = "newsCounters.newsCounter")
    UserResponse map(User user);
    @Mapping(target = "password", source = "userCreateRequest.password")
    User map(UserCreateRequest userCreateRequest);
    void update(UserUpdateRequest userUpdateRequest, @MappingTarget User user);
    List<UserResponse> map(List<User> users);
    @Mapping(target = "countComments", source = "commentCounters.comments")
    @Mapping(target = "countNews", source = "newsCounters.newsCounter")
    UserShortResponse mapToShortResponse(User user);
}
