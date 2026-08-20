package com.coop_plus.api.Services;

import com.coop_plus.api.Entitys.UserRole;
import com.coop_plus.api.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean emailExistente(String email){
        return userRepository.findByEmail(email) != null;
    }


}
