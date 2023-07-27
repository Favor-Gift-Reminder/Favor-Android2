package com.nise.favor_android.Interface.Service

import com.appcenter.favor.Interface.ResponseDTO.signIn
import com.appcenter.favor.Interface.ResponseDTO.userResult
import com.nise.favor_android.Interface.ResponseDTO.Reminder
import com.nise.favor_android.Interface.ResponseDTO.User
import com.nise.favor_android.Interface.UserDTO.userUpdateDTO
import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Login.ProfileMake
import com.nise.favor_android.Login.passwordDto
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("users")
    fun chechUser(
        @Header("token") token: String
    ):Call<userResult>
    @POST("users/sign-up")
    fun requestLogin(
        @Body loginRequest: LoginRequest
    ) : Call<userResult>

    @POST("users/sign-in")
    fun Login(
        @Body loginRequest: LoginRequest
    ) : Call<signIn>

    @PATCH("users/profile")
    fun makeProfile(
        @Header("token") token: String,
        @Body profileMake: ProfileMake
    ): Call<userResult>

    @PATCH("users")
    fun repairUser(
        @Header("token") token: String,
        @Body userUpdateDTO: userUpdateDTO
    ): Call<User>

    @GET("users/friend-list")
    fun friendList(
        @Header("token") token: String
    ): Call<User>

    @GET("users/gift-by-category/{category}")
    fun giftByCategory(
        @Header("token") token: String,
        @Path("category") category : String
    ): Call<User>

    @GET("users/gift-by-emotion/{emotion}")
    fun giftByEmotion(
        @Header("token") token: String,
        @Path("emotion") emotion:String
    ): Call<User>

    @GET("users/gift-by-name/{giftName}")
    fun giftByName(
        @Header("token") token: String,
        @Path("giftName") giftName: String
    ): Call<User>

    @GET("users/gift-list")
    fun giftList(
        @Header("token") token: String
    ):Call<User>

    @GET("users/id")
    fun idList(
        @Header("token") token: String,
        @Path("userId") userId:String
    ): Call<User>

    @PATCH("users/password")
    fun changePassword(
        @Header("token") token: String,
        @Body passwordDto: passwordDto
    ): Call<User>

    @GET("users/reminder-list")
    fun reminderList(
        @Header("token") token: String
    ): Call<User>

    @GET("users/reminder-list/{year}/{month}")
    fun filterReminder(
        @Header("token") token: String,
        @Path("month") month: Int,
        @Path("year") year:Int
    ): Call<Reminder>

    @DELETE("users")
    fun deletUser(
        @Header("token") token: String
    ):Call<User>
}