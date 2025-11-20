package com.mvvm_with_recyclerview.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mvvm_with_recyclerview.model.User;
import com.mvvm_with_recyclerview.network.ApiService;
import com.mvvm_with_recyclerview.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private ApiService apiService;
    public UserRepository()
    {
        apiService = RetrofitClient.getApiService();
    }
    public LiveData<List<User>> getUsers()
    {
        MutableLiveData<List<User>> listMutableLiveData = new MutableLiveData<>();
        apiService.getUsersList().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful())
                {
                    listMutableLiveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listMutableLiveData.setValue(null);
            }
        });
        return listMutableLiveData;
    }
}
