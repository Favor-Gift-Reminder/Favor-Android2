package com.nise.favor_android.Interface.ResponseDTO

data class User(
    val anniversaryList: List<Anniversary>,
    val email: String,
    val favorList: List<String>,
    val friendList: List<Friend>,
    val giftList: List<Gift>,
    val name: String,
    val reminderList: List<Reminder>,
    val role: String,
    val userNo: Int,
    val userid: String
)