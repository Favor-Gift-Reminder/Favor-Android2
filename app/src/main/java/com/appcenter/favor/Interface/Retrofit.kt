package com.nise.favor_android.Interface

import com.nise.favor_android.Interface.Service.AnniversaryService
import com.nise.favor_android.Interface.Service.FriendService
import com.nise.favor_android.Interface.Service.GiftService
import com.nise.favor_android.Interface.Service.ReminderService
import com.nise.favor_android.Interface.Service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val BaseUrl = "https://favor.inuappcenter.kr"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userService : UserService = retrofit.create(UserService::class.java)
    val reminderService : ReminderService = retrofit.create(ReminderService::class.java)
    val giftService : GiftService = retrofit.create(GiftService::class.java)
    val friendService : FriendService = retrofit.create(FriendService::class.java)
    val anniversaryService : AnniversaryService = retrofit.create(AnniversaryService::class.java)
}

