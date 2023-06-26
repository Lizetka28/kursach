package com.example.kursach.servise;


import com.example.kursach.model.Role;
import com.example.kursach.model.User;
import com.example.kursach.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {//принимает пользователя, создает и записывает пользоввателя в бд
        String userEmail = user.getEmail();
        if (userRepository.findByEmail(userEmail) != null) return false;// если пользователь с таким логиом(почтой) уже существует, то возвращает false
        user.setActive(true);// делает пользователя активным
        user.getRoles().add(Role.ROLE_USER);//затает роль "пользователь"
        user.setPassword(passwordEncoder.encode(user.getPassword()));//шифрует переданный в форме пароль
        log.info("Saving new User with email: {}", userEmail);
        userRepository.save(user);
        return true;
    }
    public List<User> list(){
        return userRepository.findAll();
    }//возвращет всех пользователей из бд
    public void banUser(Long id){
        User user=userRepository.findById(id).orElse(null);//ищет пользователя по id
        if(user!=null){
            if(user.isActive()){//если пользователь активен, то делает его неактивным
                user.setActive(false);
                log.info("Ban user with id = {}; email: {}", user.getId(), user.getEmail());
            }
            else{//если пользователь неактивен, то делает его активным
                user.setActive(true);
                log.info("Unban user with id = {}; email: {}", user.getId(), user.getEmail());
            }
        }
        userRepository.save(user);//сохраняет обновлённого пользователя в бд
    }
    public User getUserByPrincipal(Principal principal){
        return userRepository.findByEmail(principal.getName());
    }//возвращает текущего пользователя
    public void changeUserRoles(User user, Map<String, String> form){
        Set<String > roles= Arrays.stream(Role.values())// преобразует роли в строки и делает из них множество
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();//очищает роли пользователя
        for(String key:form.keySet()){//проходится по каждому ключу из Map, который был передан в форме
            if(roles.contains(key)){//если ключ совпадает с одной из ролей, то устанавливает её пользователю
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);//сохраняет обновлённого пользователя
    }
}
