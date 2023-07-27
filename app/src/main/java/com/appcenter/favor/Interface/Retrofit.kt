package com.nise.favor_android.Interface

import com.appcenter.favor.UserData
import com.nise.favor_android.Interface.Service.AnniversaryService
import com.nise.favor_android.Interface.Service.FriendService
import com.nise.favor_android.Interface.Service.GiftService
import com.nise.favor_android.Interface.Service.ReminderService
import com.nise.favor_android.Interface.Service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val BaseUrl = "https://favor.inuappcenter.kr"
    fun getApiClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    val userService : UserService = getApiClient().create(UserService::class.java)
    val reminderService : ReminderService = getApiClient().create(ReminderService::class.java)
    val giftService : GiftService = getApiClient().create(GiftService::class.java)
    val friendService : FriendService = getApiClient().create(FriendService::class.java)
    val anniversaryService : AnniversaryService = getApiClient().create(AnniversaryService::class.java)
}

