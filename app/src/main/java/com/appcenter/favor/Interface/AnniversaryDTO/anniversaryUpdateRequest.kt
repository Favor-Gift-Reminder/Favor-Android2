package com.nise.favor_android.Interface.AnniversaryDTO

data class anniversaryUpdateRequest(
    val anniversaryDate: String,
    val anniversaryTitle: String,
    val isPinned: Boolean
)