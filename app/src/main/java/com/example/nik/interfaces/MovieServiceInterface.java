package com.example.nik.interfaces;

//import com.example.hp.movies.apimodel.MovieDb;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.mime.TypedInput;

/**
 * Created by hp on 20-02-2016.
 */
public interface MovieServiceInterface {
    @FormUrlEncoded
    @POST("/login")
    void confirmSlot(@Field("email")String  uname,@Field("password")String  password, Callback<Response> responseCallback);

}
