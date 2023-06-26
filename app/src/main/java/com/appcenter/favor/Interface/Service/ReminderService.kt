package com.nise.favor_android.Interface.Service

import com.nise.favor_android.Interface.ReminderDTO.reminderRequest
import com.nise.favor_android.Interface.ReminderDTO.reminderUpdateDTO
import com.nise.favor_android.Interface.ResponseDTO.Reminder
import retrofit2.Call
import retrofit2.http.*

interface ReminderService {

    @GET("/reminders/{reminderNo}")
    fun checkReminder(
        @Path("reminderNo") reminderNo:Int
    ):Call<Reminder>

    @DELETE("/reminders/{reminderNo}")
    fun deleteReminder(
        @Path("reminderNo") reminderNo:Int
    ):Call<Reminder>

    @Headers("Content-Type: application/json")
    @PATCH("/reminders/{reminderNo}")
    fun changeReminder(
        @Query("friendNo") value: Int,
        @Path("reminderNo") reminderNo: Int,
        @Body reminderUpdateDTO: reminderUpdateDTO
    ):Call<Reminder>

    @POST("/reminders/add/{userNo}/{anniversaryNo}")
    fun addReminder(
        @Path("userNo") userNo:Int,
        @Path("anniversaryNo") anniversaryNo:Int
    ):Call<Reminder>

    @POST("/reminders/create/{userNo}/{friendNo}")
    fun createReminder(
        @Path("friendNo") friendNo:Int,
        @Path("userNo") userNo: Int,
        @Body reminderRequest: reminderRequest
    ):Call<Reminder>
}