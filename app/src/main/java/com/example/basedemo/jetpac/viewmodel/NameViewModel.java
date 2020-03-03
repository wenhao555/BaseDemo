package com.example.basedemo.jetpac.viewmodel;

import com.example.basedemo.jetpac.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel
{
    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers()
    {
        if (users == null)
        {
            users = new MutableLiveData<>();

        }
        return users;
    }

    private void loadUsers()
    {//执行异步操作来获取用户。
        
    }
}
