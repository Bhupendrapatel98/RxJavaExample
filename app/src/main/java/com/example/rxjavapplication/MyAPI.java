package com.example.rxjavapplication;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyAPI {
    @GET("posts")
    Observable<List<Posts>> getPosts();
}
