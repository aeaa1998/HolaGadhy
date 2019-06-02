package com.partners.hostpital.api

import android.database.Observable
import com.partners.hostpital.models.CalendarDatesResponse
import com.partners.hostpital.models.TokenResponse
import com.partners.hostpital.requests.UpdateDateRequest
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET
import java.util.*


interface ApiHostpital{
    //Login devuelve token
    @POST("get/token")
    @FormUrlEncoded
    fun oauthToken(
            @Field("grant_type") grantType: String,
            @Field("client_id") clientId: Int,
            @Field("client_secret") clientSecret: String,
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("scope") scope: String
    ): Call<TokenResponse>

    @GET("dates/{user_id}/{is_doctor}")
    fun datesByDate(@Path("user_id") userId: Int, @Path("is_doctor") doctorId: Int): Call<List<CalendarDatesResponse>>

    @PUT("dates/{id}")
    fun processDate(
            @Path("id") dateId: Int,
            @Body updateDateRequest: UpdateDateRequest
            ): Call<CalendarDatesResponse>


}