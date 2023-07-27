package com.nise.favor_android.Interface.ResponseDTO

data class Reminder(
    val alarmTime: String,
    val friendNo: Int,
    val isAlarmSet: Boolean,
    val memo: String,
    val reminderDate: String,
    val reminderNo: Int,
    val reminderTitle: String,
    val userNo: Int
)