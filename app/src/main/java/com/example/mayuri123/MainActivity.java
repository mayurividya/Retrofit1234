package com.example.mayuri123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    interface  Apiservice{
        @GET("/posts")
        Call<List<UserData>> getUsers();
    }
    retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    RecyclerView recyclerView;
    private  postAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        Apiservice users = retrofit.create(Apiservice.class);
        users.getUsers().enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if (response.isSuccessful() &&  response.body() !=null);
                postAdapter=new postAdapter(response.body());
                recyclerView.setAdapter(postAdapter);
            }
            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed data", Toast.LENGTH_SHORT).show();
            }
        });


    }
}