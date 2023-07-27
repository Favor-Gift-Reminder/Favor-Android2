package com.nise.favor_android.Interface.ResponseDTO

data class Friend(
    val anniversaryNoList: List<Any>,
    val favorList: List<Any>,
    val friendMemo: String,
    val friendName: String,
    val friendNo: Int,
    val friendUserNo: Int,
    val givenGift: Int,
    val receivedGift: Int,
    val reminderList: List<Any>,
    val totalGift: Int,
    val userNo: Int
)
