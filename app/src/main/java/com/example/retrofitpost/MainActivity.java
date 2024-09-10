package com.example.retrofitpost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    RecyclerView objRecyclerView;

    ArrayList<Posts> posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_list);

        objRecyclerView = findViewById(R.id.recyclerView);

        Retrofit objRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostService postService = objRetrofit.create(PostService.class);
        Call<ArrayList<Posts>> fetchPostsApiCall = postService.getPosts();
        fetchPostsApiCall.enqueue(new Callback<ArrayList<Posts>>() {
            @Override
            public void onResponse(Call<ArrayList<Posts>> call, Response<ArrayList<Posts>> response) {
                posts = response.body();
                LinearLayoutManager objLinearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                objRecyclerView.setLayoutManager(objLinearLayoutManager);

                PostsAdapter objPostsAdapter = new PostsAdapter(MainActivity.this,posts);
                objRecyclerView.setAdapter(objPostsAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Posts>> call, Throwable t) {

            }
        });
    }
}