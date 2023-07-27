package com.nise.favor_android.Interface.Service

import com.appcenter.favor.Interface.ResponseDTO.FriendResult
import com.appcenter.favor.Interface.ResponseDTO.GiftResult
import com.nise.favor_android.Interface.FriendDTO.friendRequest
import com.nise.favor_android.Interface.FriendDTO.friendUserRequest
import com.nise.favor_android.Interface.ResponseDTO.Friend
import retrofit2.Call
import retrofit2.http.*

interface FriendService {
    @GET("friends/{friendNo}")
    fun checkFriend(
        @Path("friendNo") friendNo : Int
    ):Call<FriendResult>

    @DELETE("friends/{friendNo}")
    fun deleteFriend(
        @Path("friendNo") friendNo: Int
    ):Call<FriendResult>

    @PATCH("friends/{friendNo}")
    fun changeFriend(
        @Path("friendNo") friendNo: Int,
        @Body friendUserRequest: friendUserRequest
    ):Call<FriendResult>

    @POST("friends")
    fun createFriend(
        @Body friendRequest: friendRequest
    ):Call<FriendResult>

    @GET("friends/admin")
    fun checkAllFriend():Call<FriendResult>

    @GET("friends/given-gifts/{friendNo}")
    fun checkGivenGift(
        @Path("friendNo") friendNo: Int
    ):Call<GiftResult>

    @GET("friends/received-gifts/{friendNo}")
    fun checkReceivedGift(
        @Path("friendNo") friendNo: Int
    ):Call<GiftResult>

    @GET("friends/total-gifts/{friendNo}")
    fun checkTotalGift(
        @Path("friendNo") friendNo: Int
    ):Call<GiftResult>

}