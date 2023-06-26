package com.nise.favor_android.Repository

import com.nise.favor_android.Interface.GiftDTO.GiftRequestDTO
import com.nise.favor_android.Interface.GiftDTO.GiftUpdateDTO
import com.nise.favor_android.Interface.ResponseDTO.Friend
import com.nise.favor_android.Interface.ResponseDTO.Gift
import com.nise.favor_android.Interface.ResponseDTO.User
import com.nise.favor_android.Interface.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class giftRepository {
    private val Dr = Retrofit

    fun checkGift(giftNo:Int,param:GetDataCallBack<Friend>){
        val call = Dr.giftService.checkGift(giftNo)
        call.enqueue(object : Callback<Friend>{
            override fun onResponse(call: Call<Friend>, response: Response<Friend>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun deleteGift(giftNo: Int,param:GetDataCallBack<User>){
        val call = Dr.giftService.deleteGift(giftNo)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun changeGift(giftNo: Int, GiftUpdateDto : GiftUpdateDTO,param : GetDataCallBack<Friend>){
        val call = Dr.giftService.changeGift(giftNo,GiftUpdateDto)
        call.enqueue(object :Callback<Friend>{
            override fun onResponse(call: Call<Friend>, response: Response<Friend>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun createGift(GiftRequestDto : GiftRequestDTO,userNo : Int, param:GetDataCallBack<Gift>){
        val call = Dr.giftService.createGift(GiftRequestDto,userNo)
        call.enqueue(object : Callback<Gift>{
            override fun onResponse(call: Call<Gift>, response: Response<Gift>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Gift>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}