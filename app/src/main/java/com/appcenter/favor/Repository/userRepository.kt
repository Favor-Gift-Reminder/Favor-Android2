package com.nise.favor_android.Repository

import android.util.Log
import com.nise.favor_android.Interface.ResponseDTO.Reminder
import com.nise.favor_android.Interface.ResponseDTO.User
import com.nise.favor_android.Interface.Retrofit
import com.nise.favor_android.Interface.UserDTO.userUpdateDTO
import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Login.ProfileMake
import com.nise.favor_android.Login.passwordDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class userRepository {
    private val Dr = Retrofit
    fun postRegisterForm(loginRequest: LoginRequest, param : GetDataCallBack<User>) {
        val call = Dr.userService.requestLogin(loginRequest)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("log",response.body().toString())
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }

    fun makeProfileForm(profileMake: ProfileMake, userNo: Int, param : GetDataCallBack<User>){

        val call = Dr.userService.makeProfile(profileMake, userNo)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("log",response.body().toString())
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }

    fun checkUser(userNo: Int,param:GetDataCallBack<User>){
        val call = Dr.userService.chechUser(userNo)

        call.enqueue(object :Callback<User>{
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                Log.d("log",response.body().toString())
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable){
            }

        })
    }

    fun changeUser(userUpdateDTO: userUpdateDTO,userNo: Int,param: GetDataCallBack<User>) {
        val call =Dr.userService.repairUser(userUpdateDTO,userNo)

        call.enqueue(object :Callback<User>{
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                Log.d("log",response.body().toString())
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }

    fun checkFriend(userNo: Int,param: GetDataCallBack<User>){
        val call = Dr.userService.friendList(userNo)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>
            ) {

                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }

    fun checkGiftByCategory(catagory: String, userNo: Int,param: GetDataCallBack<User>){
        val call = Dr.userService.giftByCategory(catagory,userNo)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {

            }

        })
    }

    fun checkGiftByEmotion(emotion: String,userNo: Int,param : GetDataCallBack<User>){
        val call = Dr.userService.giftByEmotion(emotion,userNo)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkGiftByName(giftName: String,userNo: Int,param : GetDataCallBack<User>){
        val call = Dr.userService.giftByName(giftName, userNo)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }

    fun checkAllGift(userNo: Int,param : GetDataCallBack<User>){
        val call = Dr.userService.giftList(userNo)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkUserById(userId: String,param: GetDataCallBack<User>){
        val call = Dr.userService.idList(userId)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }
    fun changePassword(passwordDto : passwordDto,param: GetDataCallBack<User>) {
        val call = Dr.userService.changePassword(passwordDto)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkAllReminder(userNo: Int,param:GetDataCallBack<User>){
        val call = Dr.userService.reminderList(userNo)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkReminderByFilter(month:Int,userNo:Int,year:Int,param:GetDataCallBack<Reminder>){
        val call = Dr.userService.filterReminder(month,userNo,year)
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