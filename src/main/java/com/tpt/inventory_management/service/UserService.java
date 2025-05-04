package com.tpt.inventory_management.service;

import com.tpt.inventory_management.dto.LoginRequest;
import com.tpt.inventory_management.dto.RegisterRequest;
import com.tpt.inventory_management.dto.Response;
import com.tpt.inventory_management.dto.UserDTO;
import com.tpt.inventory_management.entity.User;

public interface UserService {
    Response registerUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);

    Response getAllUsers();

    User getCurrentLoggedInUser();

    Response getUserById(Long id);

    Response updateUser(Long id, UserDTO userDTO);

    Response deleteUser(Long id);

    Response getUserTransactions(Long id);
}