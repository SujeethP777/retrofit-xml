package com.example.retrofitpost;

import com.google.gson.annotations.SerializedName;

public class Posts {


    @SerializedName("userId")
    Integer postuserId;

    @SerializedName("id")
    Integer postid;

    @SerializedName("title")
    String posttitle;

    @SerializedName("body")
    String postbody;
}
