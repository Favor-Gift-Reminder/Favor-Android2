package com.nise.favor_android.Interface.ResponseDTO

data class Friend(
    val anniversaryList: List<Anniversary>,
    val favorList: List<String>,
    val friendMemo: String,
    val friendName: String,
    val friendNo: Int,
    val friendUserNo: Int,
    val giftList: List<Gift>,
    val isUser: Boolean,
    val reminderList: List<Reminder>,
    val userNo: Int
)
