package com.code.arsen.service;

import com.code.arsen.entity.User;
import com.code.arsen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> userList(){
        return userRepository.findAll();
    }

    public User save(User user){

        return userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User update(Long id, User data){

        User user = findById(id);
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setGender(data.getGender());
        user.setAge(data.getAge());

        return userRepository.save(user);
    }

    public boolean deleteUser(Long id){
            userRepository.delete(findById(id));
            return true;
    }
}
