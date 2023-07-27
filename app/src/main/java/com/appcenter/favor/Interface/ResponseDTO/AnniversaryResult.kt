package com.appcenter.favor.Interface.ResponseDTO

import com.nise.favor_android.Interface.ResponseDTO.Anniversary

data class AnniversaryResult(
    val `data`: Anniversary,
    val responseCode: String,
    val responseMessage: String
)