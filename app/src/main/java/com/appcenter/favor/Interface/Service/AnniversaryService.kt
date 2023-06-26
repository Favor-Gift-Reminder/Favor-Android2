package com.nise.favor_android.Interface.Service

import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryRequest
import com.nise.favor_android.Interface.AnniversaryDTO.anniversaryUpdateRequest
import com.nise.favor_android.Interface.ResponseDTO.Anniversary
import retrofit2.Call
import retrofit2.http.*

interface AnniversaryService {
    @GET("anniversaries/{anniversaryNo}")
    fun checkAnniversary(
        @Path("anniversaryNo") anniversaryNo: Int
    ):Call<Anniversary>

    @DELETE("anniversaries/{anniversaryNo}")
    fun deleteAnniversary(
        @Path("anniversaryNo") anniversaryNo: Int
    ):Call<Anniversary>

    @PATCH("anniversaries/{anniversaryrNo}")
    fun changeAnniversary(
        @Body anniversaryUpdateRequest: anniversaryUpdateRequest,
        @Path("anniversaryrNo") anniversaryrNo: Int
    ):Call<Anniversary>

    @POST("anniversaries/{userNo}")
    fun createAnniversary(
        @Body anniversaryRequest: anniversaryRequest,
        @Path("userNo") userNo: Int
    ):Call<Anniversary>
}