package com.appcenter.favor.Interface.ResponseDTO

data class signIn(
    val `data`: Token,
    val responseCode: String,
    val responseMessage: String
)