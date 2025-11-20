package com.mvvm_with_recyclerview.viewMpdel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mvvm_with_recyclerview.model.User;
import com.mvvm_with_recyclerview.repository.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> listUsers;

    public UserViewModel()
    {
        userRepository = new UserRepository();
        listUsers = userRepository.getUsers();
    }

    public LiveData<List<User>> getUsers()
    {
        return listUsers;
    }


}
