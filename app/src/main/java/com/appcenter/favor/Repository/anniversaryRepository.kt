package com.nise.favor_android.Repository

import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryRequest
import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryUpdateRequest
import com.nise.favor_android.Interface.ResponseDTO.Anniversary
import com.nise.favor_android.Interface.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class anniversaryRepository {
    private val Dr = Retrofit

    fun checkAnniversary(anniversaryNo:Int,param:GetDataCallBack<Anniversary>){
        val call = Dr.anniversaryService.checkAnniversary(anniversaryNo)
        call.enqueue(object : Callback<Anniversary> {
            override fun onResponse(call: Call<Anniversary>, response: Response<Anniversary>) {
                TODO("Not yet implemented")
            }
            override fun onFailure(call: Call<Anniversary>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun deleteAnniversary(anniversaryNo: Int,param:GetDataCallBack<Anniversary>){
        val call = Dr.anniversaryService.deleteAnniversary(anniversaryNo)
        call.enqueue(object :Callback<Anniversary>{
            override fun onResponse(call: Call<Anniversary>, response: Response<Anniversary>) {
                TODO("Not yet implemented")
            }
            override fun onFailure(call: Call<Anniversary>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun changeAnniversary(anniversaryUpdateRequest: anniversaryUpdateRequest,anniversaryNo: Int,param: GetDataCallBack<Anniversary>){
        val call = Dr.anniversaryService.changeAnniversary(anniversaryUpdateRequest,anniversaryNo)
        call.enqueue(object : Callback<Anniversary>{
            override fun onResponse(call: Call<Anniversary>, response: Response<Anniversary>) {
                TODO("Not yet implemented")
            }
            override fun onFailure(call: Call<Anniversary>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun createAnniversary(anniversaryRequest: anniversaryRequest,userNo:Int,param:GetDataCallBack<Anniversary>){
        val call = Dr.anniversaryService.createAnniversary(anniversaryRequest,userNo)
        call.enqueue(object :Callback<Anniversary>{
            override fun onResponse(call: Call<Anniversary>, response: Response<Anniversary>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Anniversary>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}