package com.appcenter.favor.Interface.ResponseDTO

import com.nise.favor_android.Interface.ResponseDTO.Friend

data class FriendResult(
    val `data`: Friend,
    val responseCode: String,
    val responseMessage: String
)