package com.nise.favor_android.Repository

import com.nise.favor_android.Interface.ReminderDTO.reminderRequest
import com.nise.favor_android.Interface.ReminderDTO.reminderUpdateDTO
import com.nise.favor_android.Interface.ResponseDTO.Reminder
import com.nise.favor_android.Interface.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class reminderRepository {
    private val Dr = Retrofit

    fun checkReminder(reminderNo : Int,param : GetDataCallBack<Reminder>){
        val call = Dr.reminderService.checkReminder(reminderNo)
        call.enqueue(object :Callback<Reminder>{
            override fun onResponse(call: Call<Reminder>, response: Response<Reminder>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<Reminder>, t: Throwable){
            }
        })
    }

    fun changeReminder(friendNo : Int, reminderNo: Int,reminderUpdateDTO: reminderUpdateDTO,param:GetDataCallBack<Reminder>){
        val call = Dr.reminderService.changeReminder(friendNo,reminderNo,reminderUpdateDTO)
        call.enqueue(object : Callback<Reminder>{
            override fun onResponse(call: Call<Reminder>, response: Response<Reminder>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<Reminder>, t: Throwable) {
            }
        })
    }

    fun addReminder(anniversaryNo : Int, userNo: Int,param: GetDataCallBack<Reminder>){
        val call = Dr.reminderService.addReminder(anniversaryNo,userNo)
        call.enqueue(object :Callback<Reminder>{
            override fun onResponse(call: Call<Reminder>, response: Response<Reminder>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<Reminder>, t: Throwable) {
            }
        })
    }

    fun createReminder(friendNo: Int,userNo: Int,reminderRequest: reminderRequest,param : GetDataCallBack<Reminder>){
        val call = Dr.reminderService.createReminder(friendNo,userNo,reminderRequest)
        call.enqueue(object :Callback<Reminder>{
            override fun onResponse(call: Call<Reminder>, response: Response<Reminder>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<Reminder>, t: Throwable) {
            }
        })

    }

    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}