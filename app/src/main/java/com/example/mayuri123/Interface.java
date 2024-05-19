package com.example.mayuri123;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class Interface {
    interface  ApiService{
        @GET("/posts")
        Call<List<UserData>>  getUsers();
    }
}
