package com.nise.favor_android.Interface.Service

import com.nise.favor_android.Interface.ResponseDTO.Reminder
import com.nise.favor_android.Interface.ResponseDTO.User
import com.nise.favor_android.Interface.UserDTO.userUpdateDTO
import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Login.ProfileMake
import com.nise.favor_android.Login.passwordDto
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("users/{userNo}")
    fun chechUser(
        @Path("userNo") userNo: Int
    ):Call<User>
    @POST("users/sign-up")
    fun requestLogin(
        @Body loginRequest: LoginRequest
    ) : Call<User>

    @Headers("Content-Type: application/json")
    @PATCH("users/profile")
    fun makeProfile(
        @Body profileMake: ProfileMake,
        @Query("userNo") value : Int
    ): Call<User>

    @Headers("Content-Type: application/json")
    @PATCH("users/{userNo}")
    fun repairUser(
        @Body userUpdateDTO: userUpdateDTO,
        @Path("userNo") userMo : Int
    ): Call<User>

    @GET("users/friend-list/{userNo}")
    fun friendList(
        @Path("userNo") userNo: Int
    ): Call<User>

    @GET("users/gift-by-category/{userNo}/{category}")
    fun giftByCategory(
        @Path("category") category : String,
        @Path("userNo") userNo: Int
    ): Call<User>

    @GET("users/gift-by-emotion/{userNo}/{emotion}")
    fun giftByEmotion(
        @Path("emotion") emotion:String,
        @Path("userNo") userNo:Int
    ): Call<User>

    @GET("users/gift-by-name/{userNo}/{giftName}")
    fun giftByName(
        @Path("giftName") giftName: String,
        @Path("userNo") userNo: Int
    ): Call<User>

    @GET("users/gift-list/{userNo}")
    fun giftList(
        @Path("userNo") userNo: Int
    ):Call<User>

    @GET("users/id/{userId}")
    fun idList(
        @Path("userId") userId:String
    ): Call<User>

    @PATCH("users/password")
    fun changePassword(
        @Body passwordDto: passwordDto
    ): Call<User>

    @GET("users/reminder-list/{userNo}")
    fun reminderList(
        @Path("userNo") userNo:Int
    ): Call<User>

    @GET("users/reminder-list/{userNo}/{year}/{month}")
    fun filterReminder(
        @Path("month") month: Int,
        @Path("userNo") userMo: Int,
        @Path("year") year:Int

    ): Call<Reminder>
}