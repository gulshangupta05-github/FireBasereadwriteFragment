package com.example.firebasereadwrite.userInfo

import com.google.gson.annotations.SerializedName

data  class UserInfo(
    @SerializedName ("name")
    val name:String="",

    @SerializedName("email")
    val email:String="",

    @SerializedName("address")
    val address:String="",

    @SerializedName("mobile")
    val mobile:String=""
)
