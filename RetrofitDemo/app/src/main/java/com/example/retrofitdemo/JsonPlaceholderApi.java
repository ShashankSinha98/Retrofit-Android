package com.example.retrofitdemo;

import android.content.Intent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

//3.  Represent API of web service in our app
public interface JsonPlaceholderApi {


    // getting data from https://jsonplaceholder.typicode.com/posts, where https://jsonplaceholder.typicode.com/ is base url(always ennd with /)
    // and posts is relative url (we can pass complete url in GET too, it'll replace base url and we'll get results)
    @GET("posts") // telling retrofit to implement this method for getting posts data from api
    Call<List<Post>> getPost(); // code will be generated by retrofit to get list of post - response from API, JSON Obj

    // Call encapsulate a single request and response, we use it execute get request


    // Path annotation is used to pass argument to out methods in API, which can be replaced by same string in {} in out GET url.
    // arg name need not to be same, but Path("x") need to be same as GET("../{x}/..")
    /*
    * This is used for url of type.. (posts/id/comments)
    * */
    @GET("posts/{id}/comments")// we can have multiple arg , {} in path too (".../{}/.../{}/...")
    Call<List<Comment>> getComments(@Path("id")int postId);


    @GET("posts")// same as posts?userId=uId, retrofit will automatically put ? and = at required places
    Call<List<Post>> getPostUsingUserId(@Query("userId") int uId);

    // we can have multiple queries like "posts?userId=2&_sort=id&_order=desc"
    @GET("posts") // if we don't want to pass any parameter, we can put null, but we can't put int userId as null bcz it is primitive type,
    // so we use Wrapper Integer class which can be put null
    Call<List<Post>> getPostUsingMultipleQueries(@Query("userId") Integer userId, @Query("_sort") String sort, @Query("_order") String order);

    @GET("posts")
    Call<List<Post>> getPostForMultipleUserIds(@Query("userId") Integer[] userId);

    // If we want to decide which query to pass without defining it in method, we use @QueryMap
    @GET("posts")
    Call<List<Post>> getPostsWithDynamicQuery(@QueryMap Map<String,String> parameters); // Here Key is what we put inside @Query("") and Value is the corresponding argument
    // eg- @Query("userId") Integer userId, then HashMap key- String userId, value- userId that you want to get

    // If we want to pass the @GET relative url at run time, we use @URL
    @GET
    Call<List<Comment>> getComments(@Url String url);
}
