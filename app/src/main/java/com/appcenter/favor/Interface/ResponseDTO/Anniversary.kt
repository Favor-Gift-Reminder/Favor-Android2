package com.nise.favor_android.Interface.ResponseDTO

data class Anniversary(
    val anniversaryDate: String,
    val anniversaryNo: Int,
    val anniversaryTitle: String,
    val isPinned: Boolean,
    val userNo: Int,
    val createAt: String,
    val modifiedAt: String
)