package com.partners.hostpital.models

import com.google.gson.annotations.SerializedName

class DoctorResponse (@SerializedName("first_name") val first_name: String,
                     @SerializedName("last_name") val lastName: String,
                     @SerializedName("user_oid") val userId: Int,
                     @SerializedName("doctor_type_id") val doctorTypeId: Int,
                     @SerializedName("latitud") val latitud: Double,
                     @SerializedName("longitud") val longitud: Double
)