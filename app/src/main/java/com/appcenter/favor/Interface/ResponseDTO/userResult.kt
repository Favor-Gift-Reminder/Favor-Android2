package com.appcenter.favor.Interface.ResponseDTO

import com.nise.favor_android.Interface.ResponseDTO.User

data class userResult(
    val `data`: User,
    val responseCode: String,
    val responseMessage: String
)
