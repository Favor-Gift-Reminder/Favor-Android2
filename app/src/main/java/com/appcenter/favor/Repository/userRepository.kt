package com.nise.favor_android.Repository

import android.util.Log
import com.appcenter.favor.App
import com.appcenter.favor.Interface.ResponseDTO.signIn
import com.appcenter.favor.Interface.ResponseDTO.userResult
import com.appcenter.favor.UserData
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
    fun postRegisterForm(loginRequest: LoginRequest, param : GetDataCallBack<userResult>) {
        val call = Dr.userService.requestLogin(loginRequest)
        call.enqueue(object : Callback<userResult> {
            override fun onResponse(call: Call<userResult>, response: Response<userResult>) {
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<userResult>, t: Throwable) {
            }
        })
    }
    fun Login(loginRequest: LoginRequest, param: GetDataCallBack<signIn>){
        val call = Dr.userService.Login(loginRequest)
        call.enqueue(object : Callback<signIn>{
            override fun onResponse(call: Call<signIn>, response: Response<signIn>) {
                App.userData.setAccessToken(response.body()?.data?.token)
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<signIn>, t: Throwable) {
            }

        })
    }

    fun makeProfileForm(token: String,profileMake: ProfileMake, param : GetDataCallBack<userResult>){

        val call = Dr.userService.makeProfile(token,profileMake)
        call.enqueue(object : Callback<userResult> {
            override fun onResponse(call: Call<userResult>, response: Response<userResult>) {
                Log.d("log",response.body().toString())
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<userResult>, t: Throwable) {
            }
        })
    }

    fun checkUser(token: String,param:GetDataCallBack<userResult>){
        val call = Dr.userService.chechUser(token)

        call.enqueue(object :Callback<userResult>{
            override fun onResponse(
                call: Call<userResult>,
                response: Response<userResult>
            ) {
                Log.d("log",response.body().toString())
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<userResult>, t: Throwable){
            }

        })
    }

    fun changeUser(token: String,userUpdateDTO: userUpdateDTO,param: GetDataCallBack<User>) {
        val call =Dr.userService.repairUser(token,userUpdateDTO)

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

    fun checkFriend(token: String,param: GetDataCallBack<User>){
        val call = Dr.userService.friendList(token)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>
            ) {
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }

    fun checkGiftByCategory(token: String,catagory: String,param: GetDataCallBack<User>){
        val call = Dr.userService.giftByCategory(token,catagory)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {

            }

        })
    }

    fun checkGiftByEmotion(token: String,emotion: String,param : GetDataCallBack<User>){
        val call = Dr.userService.giftByEmotion(token,emotion)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkGiftByName(token: String,giftName: String,param : GetDataCallBack<User>){
        val call = Dr.userService.giftByName(token,giftName)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }

    fun checkAllGift(token: String,param : GetDataCallBack<User>){
        val call = Dr.userService.giftList(token)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkUserById(token: String,userId: String,param: GetDataCallBack<User>){
        val call = Dr.userService.idList(token,userId)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }
    fun changePassword(token: String,passwordDto : passwordDto,param: GetDataCallBack<User>) {
        val call = Dr.userService.changePassword(token,passwordDto)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkAllReminder(token: String,param:GetDataCallBack<User>){
        val call = Dr.userService.reminderList(token)
        call.enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    fun checkReminderByFilter(token: String,month:Int,year:Int,param:GetDataCallBack<Reminder>){
        val call = Dr.userService.filterReminder(token,month,year)
        call.enqueue(object :Callback<Reminder>{
            override fun onResponse(call: Call<Reminder>, response: Response<Reminder>) {
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<Reminder>, t: Throwable) {
            }
        })
    }

    fun deleteUser(token: String,param:GetDataCallBack<User>){
        val call = Dr.userService.deletUser(token)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }
    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }
}