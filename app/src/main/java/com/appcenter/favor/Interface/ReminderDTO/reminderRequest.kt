package com.nise.favor_android.Interface.ReminderDTO

data class reminderRequest(
    val alarmTime: String,
    val isAlarmSet: Boolean,
    val reminderDate: String,
    val reminderMemo: String,
    val reminderTitle: String
)