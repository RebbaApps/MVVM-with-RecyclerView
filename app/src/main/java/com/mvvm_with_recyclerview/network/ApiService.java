package com.mvvm_with_recyclerview.network;

import com.mvvm_with_recyclerview.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Call<List<User>> getUsersList();
}
