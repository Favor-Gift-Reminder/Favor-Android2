package com.nise.favor_android.Repository

import com.appcenter.favor.Interface.ResponseDTO.FriendResult
import com.nise.favor_android.Interface.FriendDTO.friendRequest
import com.nise.favor_android.Interface.FriendDTO.friendUserRequest
import com.nise.favor_android.Interface.ResponseDTO.Friend
import com.nise.favor_android.Interface.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class firendRepository {
    private val Dr = Retrofit

    fun checkFriend(friendNo : Int,param : GetDataCallBack<FriendResult>){
        val call = Dr.friendService.checkFriend(friendNo)
        call.enqueue(object : Callback<FriendResult> {
            override fun onResponse(call: Call<FriendResult>, response: Response<FriendResult>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<FriendResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun deleteFriend(friendNo: Int,param: GetDataCallBack<FriendResult>){
        val call = Dr.friendService.deleteFriend(friendNo)
        call.enqueue(object :Callback<FriendResult>{
            override fun onResponse(call: Call<FriendResult>, response: Response<FriendResult>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<FriendResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun changeFriend(friendNo: Int,friendUserRequest: friendUserRequest,param : GetDataCallBack<FriendResult>){
        val call = Dr.friendService.changeFriend(friendNo, friendUserRequest)
        call.enqueue(object : Callback<FriendResult>{
            override fun onResponse(call: Call<FriendResult>, response: Response<FriendResult>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<FriendResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun createFriend(friendRequest: friendRequest, param: GetDataCallBack<FriendResult>){
        val call = Dr.friendService.createFriend(friendRequest)
        call.enqueue(object : Callback<FriendResult>{
            override fun onResponse(call: Call<FriendResult>, response: Response<FriendResult>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<FriendResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}