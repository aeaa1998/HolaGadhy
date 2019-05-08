package com.partners.hostpital.models

import com.google.gson.annotations.SerializedName

class TokenResponse (@SerializedName("token_type") val tokenType: String,
                     @SerializedName("expires_in") val expiresIn: Long,
                     @SerializedName("access_token") val accessToken: String,
                     @SerializedName("refresh_token") val refreshToken: String)