package com.nise.favor_android.Repository

import com.appcenter.favor.Interface.ResponseDTO.AnniversaryResult
import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryRequest
import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryUpdateRequest
import com.nise.favor_android.Interface.ResponseDTO.Anniversary
import com.nise.favor_android.Interface.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class anniversaryRepository {
    private val Dr = Retrofit

    fun checkAnniversary(anniversaryNo:Int,param:GetDataCallBack<AnniversaryResult>){
        val call = Dr.anniversaryService.checkAnniversary(anniversaryNo)
        call.enqueue(object : Callback<AnniversaryResult> {
            override fun onResponse(call: Call<AnniversaryResult>, response: Response<AnniversaryResult>) {
                TODO("Not yet implemented")
            }
            override fun onFailure(call: Call<AnniversaryResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun deleteAnniversary(anniversaryNo: Int,param:GetDataCallBack<AnniversaryResult>){
        val call = Dr.anniversaryService.deleteAnniversary(anniversaryNo)
        call.enqueue(object :Callback<AnniversaryResult>{
            override fun onResponse(call: Call<AnniversaryResult>, response: Response<AnniversaryResult>) {
                TODO("Not yet implemented")
            }
            override fun onFailure(call: Call<AnniversaryResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun changeAnniversary(anniversaryUpdateRequest: anniversaryUpdateRequest,anniversaryNo: Int,param: GetDataCallBack<Anniversary>){
        val call = Dr.anniversaryService.changeAnniversary(anniversaryUpdateRequest,anniversaryNo)
        call.enqueue(object : Callback<AnniversaryResult>{
            override fun onResponse(call: Call<AnniversaryResult>, response: Response<AnniversaryResult>) {
                TODO("Not yet implemented")
            }
            override fun onFailure(call: Call<AnniversaryResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun createAnniversary(anniversaryRequest: anniversaryRequest,param:GetDataCallBack<AnniversaryResult>){
        val call = Dr.anniversaryService.createAnniversary(anniversaryRequest)
        call.enqueue(object :Callback<AnniversaryResult>{
            override fun onResponse(call: Call<AnniversaryResult>, response: Response<AnniversaryResult>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<AnniversaryResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}