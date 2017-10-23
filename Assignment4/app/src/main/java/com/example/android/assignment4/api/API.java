package com.example.android.assignment4.api;

import com.example.android.assignment4.models.Album;
import com.example.android.assignment4.models.Comment;
import com.example.android.assignment4.models.Photo;
import com.example.android.assignment4.models.Post;
import com.example.android.assignment4.models.Todo;
import com.example.android.assignment4.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Sushila on 9/13/2017.
 */

public interface API {
    @GET("/posts")
    Call<ArrayList<Post>> getPosts();
    @GET("/posts/{userId}/comments")
    Call<ArrayList<Comment>> getCommentsByPosts(@Path("userId") int userId);
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();
    @GET("/albums/{userId}/photos")
    Call<ArrayList<Photo>> getPhotosByAlbums(@Path("userId")int userId);
    @GET("/todos")
    Call<ArrayList<Todo>> getTodos();
    @GET("/users")
    Call<ArrayList<User>> getUsers();
    @GET("/posts")
    Call<ArrayList<Post>> getPostsOfUsers(@Query("userId")int userId);
    @GET("/todos")
    Call<ArrayList<Todo>> getTodosOfUsers(@Query("userId") int userId);

}
