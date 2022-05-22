package com.rashad.data.features.auth

import com.rashad.data.features.auth.responses.CategoryRemote
import com.rashad.data.features.auth.responses.OptionsChildRemote
import com.rashad.data.utils.Endpoints
import com.rashad.data.utils.parser.BaseResponse
import io.reactivex.Single
import retrofit2.http.*
import java.util.*


interface AuthApiService {

    @GET(Endpoints.Task.getAllCats)
    fun getAllCats(): Single<BaseResponse<CategoryRemote>>

    @GET(Endpoints.Task.getOptionsChildById)
    fun getOptionsChildById(
        @Path("child_options") id: String
    ): Single<BaseResponse<List<OptionsChildRemote>>>

    @GET(Endpoints.Task.propertiesById)
    fun propertiesById(
        @Query("cat") id: String
    ): Single<BaseResponse<List<OptionsChildRemote>>>


}