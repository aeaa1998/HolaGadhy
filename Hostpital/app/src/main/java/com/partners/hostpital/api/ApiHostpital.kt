package com.partners.hostpital.api

import com.partners.hostpital.models.TokenResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiHostpital{
    //Login
    @POST("/oauth/token")
    @FormUrlEncoded
    fun oauthToken(
            @Field("grant_type") grantType: String,
            @Field("client_id") clientId: Int,
            @Field("client_secret") clientSecret: String,
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("scope") scope: String
    ): Call<TokenResponse>
}