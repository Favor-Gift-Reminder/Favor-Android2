package com.appcenter.favor.Interface.ResponseDTO

import com.nise.favor_android.Interface.ResponseDTO.Gift

data class GiftResult(
    val `data`: Gift,
    val responseCode: String,
    val responseMessage: String
)