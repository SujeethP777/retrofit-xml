package com.example.retrofitpost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("posts")
    Call<ArrayList<Posts>> getPosts();
}
