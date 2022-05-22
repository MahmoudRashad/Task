package com.rashad.data.features.auth


import com.rashad.data.features.auth.mappers.mapToCategoryRemoteModel
import com.rashad.data.features.auth.mappers.mapToOptionsChildModel
import com.rashad.data.features.auth.responses.CategoryRemote
import com.rashad.domain.authentication.models.CategoryModel
import com.rashad.domain.authentication.models.OptionChildModel
import com.rashad.domain.authentication.repositories.AuthenticationRepository
import io.reactivex.Single
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authService: AuthApiService
) : AuthenticationRepository {

    override fun getAllCats( ): Single<CategoryModel> =
        authService.getAllCats().flatMap {
            Single.just(it.data?.mapToCategoryRemoteModel())
        }

    override fun getOptionsChildById( id :String ): Single<List<OptionChildModel>> =
        authService.getOptionsChildById(id).flatMap {
            Single.just(it.data?.map {
                it.mapToOptionsChildModel()
            })
        }
    override fun propertiesById( id :String ): Single<List<OptionChildModel>> =
        authService.propertiesById(id).flatMap {
            Single.just(it.data?.map {
                it.mapToOptionsChildModel()
            })
        }



}