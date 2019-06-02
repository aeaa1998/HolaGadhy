package com.partners.hostpital.models

import com.google.gson.annotations.SerializedName
import java.sql.Time


class SchedulesResponse (@SerializedName("name") val id: String,
                            @SerializedName("enter_time") val enterTime: Time,
                            @SerializedName("exit_time") val exitTime: Time
)