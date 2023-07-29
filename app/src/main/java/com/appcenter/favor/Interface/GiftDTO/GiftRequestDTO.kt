package com.nise.favor_android.Interface.GiftDTO

import com.nise.favor_android.Interface.ResponseDTO.Friend

data class GiftRequestDTO(
    val category: String,
    val emotion: String,
    val friendNoList: List<Int>,
    val giftDate: String,
    val giftMemo: String,
    val giftName: String,
    val isGiven: Boolean,
    val isPinned: Boolean
)