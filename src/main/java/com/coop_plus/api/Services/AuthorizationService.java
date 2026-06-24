package com.coop_plus.api.Services;

import com.coop_plus.api.Repositorys.ClientRepository;
import com.coop_plus.api.Repositorys.EmployeeRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails emp = employeeRepository.findByEmail(username).orElseThrow(NoSuchElementException::new);
        UserDetails cli = clientRepository.findByEmail(username);
        throw new UsernameNotFoundException("Usuario não encontrado.");
    }
}
