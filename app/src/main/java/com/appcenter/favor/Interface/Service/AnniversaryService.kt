package com.nise.favor_android.Interface.Service

import com.appcenter.favor.Interface.ResponseDTO.AnniversaryResult
import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryRequest
import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryUpdateRequest
import com.nise.favor_android.Interface.ResponseDTO.Anniversary
import retrofit2.Call
import retrofit2.http.*

interface AnniversaryService {
    @GET("anniversaries/{anniversaryNo}")
    fun checkAnniversary(
        @Path("anniversaryNo") anniversaryNo: Int
    ):Call<AnniversaryResult>

    @DELETE("anniversaries/{anniversaryNo}")
    fun deleteAnniversary(
        @Path("anniversaryNo") anniversaryNo: Int
    ):Call<AnniversaryResult>

    @PATCH("anniversaries/{anniversaryrNo}")
    fun changeAnniversary(
        @Body anniversaryUpdateRequest: anniversaryUpdateRequest,
        @Path("anniversaryrNo") anniversaryrNo: Int
    ):Call<AnniversaryResult>

    @POST("anniversaries")
    fun createAnniversary(
        @Body anniversaryRequest: anniversaryRequest
    ):Call<AnniversaryResult>

    @GET("anniversaries/admin")
    fun getAllAnniversary():Call<AnniversaryResult>

    @PATCH("anniversaries/pin/{anniversaryNo}")
    fun pinChangeAnniversary(
        @Path("anniversaryNo") anniversaryNo: Int
    ):Call<AnniversaryResult>
}