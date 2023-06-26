package com.nise.favor_android.Interface.Service

import com.nise.favor_android.Interface.GiftDTO.GiftRequestDTO
import com.nise.favor_android.Interface.GiftDTO.GiftUpdateDTO
import com.nise.favor_android.Interface.ResponseDTO.*
import retrofit2.Call
import retrofit2.http.*

interface GiftService {
    @GET("/gifts")
    fun allCheckGift(): Call<User>

    @GET("/gifts/{giftNo}")
    fun checkGift(
        @Path("giftNo") giftNo: Int
    ): Call<Friend>

    @DELETE("/gifts/{giftNo}")
    fun deleteGift(
        @Path("giftNo") giftNo: Int
    ):Call<User>

    @Headers("Content-Type: application/json")
    @PATCH("/gifts/{giftNo}")
    fun changeGift(
        @Path("giftNo") giftNo: Int,
        @Body GiftUpdateDto: GiftUpdateDTO
    ):Call<Friend>

    @POST("/gifts/{userNo}")
    fun createGift(
        @Body GiftRequestDTO:GiftRequestDTO,
        @Path("userNo") userNo: Int
    ):Call<Gift>
}