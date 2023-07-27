package com.nise.favor_android.Interface.UserDTO

import com.nise.favor_android.Interface.ResponseDTO.Friend

data class userFriendDTO(
    val `data`: List<Friend>,
    val responseCode: String,
    val responseMessage: String
)