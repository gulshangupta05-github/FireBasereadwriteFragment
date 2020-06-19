package com.example.firebasereadwrite.userInfo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data  class UserInfo(
    @SerializedName ("name")
    val name:String="",

    @SerializedName("email")
    val email:String="",

    @SerializedName("address")
    val address:String="",

    @SerializedName("mobile")
    val mobile:String="",

    @SerializedName("father")
    val father:String="",

    @SerializedName("mother")
    val  mother:String="",

    @SerializedName("country")
    val country:String="",

    @SerializedName("city")
    val city:String="",

    @SerializedName("postal")
    val postal:String="",

    @SerializedName("company")
    val company :String=""
) : Serializable
