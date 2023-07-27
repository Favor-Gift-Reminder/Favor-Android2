package com.nise.favor_android.Interface.Service

import com.appcenter.favor.Interface.ResponseDTO.GiftResult
import com.nise.favor_android.Interface.GiftDTO.GiftRequestDTO
import com.nise.favor_android.Interface.GiftDTO.GiftUpdateDTO
import com.nise.favor_android.Interface.ResponseDTO.*
import retrofit2.Call
import retrofit2.http.*

interface GiftService {
    @GET("gifts/admin")
    fun allCheckGift(): Call<GiftResult>

    @GET("gifts/{giftNo}")
    fun checkGift(
        @Path("giftNo") giftNo: Int
    ): Call<GiftResult>

    @DELETE("gifts/{giftNo}")
    fun deleteGift(
        @Path("giftNo") giftNo: Int
    ):Call<GiftResult>

    @Headers("Content-Type: application/json")
    @PATCH("gifts/{giftNo}")
    fun changeGift(
        @Path("giftNo") giftNo: Int,
        @Body GiftUpdateDto: GiftUpdateDTO
    ):Call<GiftResult>

    @POST("gifts")
    fun createGift(
        @Body GiftRequestDTO:GiftRequestDTO
    ):Call<GiftResult>

    @PATCH("gifts/pin/{giftNo}")
    fun pinnedGift(
        @Path("giftNo") giftNo: Int
    ):Call<GiftResult>


}