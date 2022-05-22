package com.rashad.domain.authentication.tasksusecase

import com.rashad.domain.authentication.models.CategoryModel
import com.rashad.domain.authentication.models.OptionChildModel
import com.rashad.domain.authentication.repositories.AuthenticationRepository
import io.reactivex.Single
import javax.inject.Inject

class CatsUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun invoke(
    ): Single<CategoryModel> =
        authenticationRepository.getAllCats()

}