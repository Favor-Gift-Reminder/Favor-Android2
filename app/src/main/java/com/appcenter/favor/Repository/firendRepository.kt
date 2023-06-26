package com.nise.favor_android.Repository

import com.nise.favor_android.Interface.FriendDTO.friendRequest
import com.nise.favor_android.Interface.FriendDTO.friendUserRequest
import com.nise.favor_android.Interface.ResponseDTO.Friend
import com.nise.favor_android.Interface.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class firendRepository {
    private val Dr = Retrofit

    fun checkFriend(friendNo : Int,param : GetDataCallBack<Friend>){
        val call = Dr.friendService.checkFriend(friendNo)
        call.enqueue(object : Callback<Friend> {
            override fun onResponse(call: Call<Friend>, response: Response<Friend>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun deleteFriend(friendNo: Int,param: GetDataCallBack<Friend>){
        val call = Dr.friendService.deleteFriend(friendNo)
        call.enqueue(object :Callback<Friend>{
            override fun onResponse(call: Call<Friend>, response: Response<Friend>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun changeFriend(friendNo: Int,friendRequest: friendRequest,param : GetDataCallBack<Friend>){
        val call = Dr.friendService.changeFriend(friendNo, friendRequest)
        call.enqueue(object : Callback<Friend>{
            override fun onResponse(call: Call<Friend>, response: Response<Friend>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun createFriend(friendRequest: friendRequest, userNo: Int, param: GetDataCallBack<Friend>){
        val call = Dr.friendService.createFriend(friendRequest,userNo)
        call.enqueue(object : Callback<Friend>{
            override fun onResponse(call: Call<Friend>, response: Response<Friend>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun addFriend(friendUserRequest: friendUserRequest,userNo:Int,param : GetDataCallBack<Friend>){
        val call = Dr.friendService.addFriend(friendUserRequest,userNo)
        call.enqueue(object : Callback<Friend>{
            override fun onResponse(call: Call<Friend>, response: Response<Friend>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}