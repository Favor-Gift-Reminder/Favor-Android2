package com.nise.favor_android.Interface.GiftDTO

data class GiftUpdateDTO(
    val giftName: String,
    val giftDate: String,
    val giftMemo: String,
    val category: String,
    val emotion: String,
    val isPinned: Boolean,
    val isGiven: Boolean,
    val friendNoList: List<Int>
)
