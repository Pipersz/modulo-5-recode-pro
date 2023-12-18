package br.com.mercuryviagens.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mercuryviagens.domain.Role;
import br.com.mercuryviagens.domain.User;
import br.com.mercuryviagens.dto.UserDto;
import br.com.mercuryviagens.repository.RoleRepository;
import br.com.mercuryviagens.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null) {
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
