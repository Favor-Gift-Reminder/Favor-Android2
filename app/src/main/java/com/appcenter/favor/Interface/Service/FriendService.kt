package com.nise.favor_android.Interface.Service

import com.nise.favor_android.Interface.FriendDTO.friendRequest
import com.nise.favor_android.Interface.FriendDTO.friendUserRequest
import com.nise.favor_android.Interface.ResponseDTO.Friend
import retrofit2.Call
import retrofit2.http.*

interface FriendService {
    @GET("friends/{friendNo}")
    fun checkFriend(
        @Path("friendNo") friendNo : Int
    ):Call<Friend>

    @DELETE("friends/{friendNo}")
    fun deleteFriend(
        @Path("friendNo") friendNo: Int
    ):Call<Friend>

    @PATCH("friends/{friendNo}")
    fun changeFriend(
        @Path("friendNo") friendNo: Int,
        @Body friendRequest: friendRequest
    ):Call<Friend>

    @POST("friends/{userNo}")
    fun createFriend(
        @Body friendRequest: friendRequest,
        @Path("userNo") userNo : Int
    ):Call<Friend>

    @POST("friends/add/{userNo}")
    fun addFriend(
        @Body friendUserRequest:friendUserRequest,
        @Path("userNo") userNo: Int
    ):Call<Friend>
}