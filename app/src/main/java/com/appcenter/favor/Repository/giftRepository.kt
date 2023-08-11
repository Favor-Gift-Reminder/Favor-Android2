package com.nise.favor_android.Repository

import com.appcenter.favor.Interface.ResponseDTO.GiftResult
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

    fun checkGift(giftNo:Int,param:GetDataCallBack<GiftResult>){
        val call = Dr.giftService.checkGift(giftNo)
        call.enqueue(object : Callback<GiftResult>{
            override fun onResponse(call: Call<GiftResult>, response: Response<GiftResult>) {
            }

            override fun onFailure(call: Call<GiftResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun deleteGift(giftNo: Int,param:GetDataCallBack<GiftResult>){
        val call = Dr.giftService.deleteGift(giftNo)
        call.enqueue(object : Callback<GiftResult>{
            override fun onResponse(call: Call<GiftResult>, response: Response<GiftResult>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<GiftResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun changeGift(giftNo: Int, GiftUpdateDto : GiftUpdateDTO,param : GetDataCallBack<GiftResult>){
        val call = Dr.giftService.changeGift(giftNo,GiftUpdateDto)
        call.enqueue(object :Callback<GiftResult>{
            override fun onResponse(call: Call<GiftResult>, response: Response<GiftResult>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<GiftResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun createGift(GiftRequestDto : GiftRequestDTO, param:GetDataCallBack<GiftResult>){
        val call = Dr.giftService.createGift(GiftRequestDto)
        call.enqueue(object : Callback<GiftResult>{
            override fun onResponse(call: Call<GiftResult>, response: Response<GiftResult>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<GiftResult>, t: Throwable) {
            }

        })
    }

    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}