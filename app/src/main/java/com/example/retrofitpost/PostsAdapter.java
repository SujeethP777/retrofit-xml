package com.example.retrofitpost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private Context context;
    private ArrayList<Posts> posts;

    public PostsAdapter(Context context, ArrayList<Posts> posts) {
        this.context = context;
        this.posts = posts;
    }


    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater objLayoutInflater = LayoutInflater.from(context);
        View objView = objLayoutInflater.inflate(R.layout.activity_main,parent,false);
        PostsViewHolder objPostsViewHolder = new PostsViewHolder(objView);
        return objPostsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        Posts objPosts = posts.get(position);
        holder.userIdtextView.setText("UserId : " + objPosts.postuserId.toString());
        holder.idTextView.setText("Id : " + objPosts.postid.toString());
        holder.titleTextView.setText("Title : " + objPosts.posttitle);
        holder.bodyTextView.setText("Body : " + objPosts.postbody);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        TextView userIdtextView,idTextView,titleTextView,bodyTextView;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);

            userIdtextView = itemView.findViewById(R.id.userIdTextView);
            idTextView = itemView.findViewById(R.id.idTextView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            bodyTextView = itemView.findViewById(R.id.bodyTextView);
        }
    }
}