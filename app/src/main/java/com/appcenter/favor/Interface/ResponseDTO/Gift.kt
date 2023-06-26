package com.nise.favor_android.Interface.ResponseDTO


data class Gift(
    val category: String,
    val emotion: String,
    val friendList: List<Friend>,
    val giftDate: String,
    val giftMemo: String,
    val giftName: String,
    val giftNo: Int,
    val isGiven: Boolean,
    val isPinned: Boolean,
    val userNo: Int
)