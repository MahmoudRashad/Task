package com.rashad.domain.authentication.tasksusecase

import com.rashad.domain.authentication.models.OptionChildModel
import com.rashad.domain.authentication.repositories.AuthenticationRepository
import io.reactivex.Single
import javax.inject.Inject

class PropertiesUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun invoke( id : String ): Single<List<OptionChildModel>> =
        authenticationRepository.propertiesById(id)
}