package com.rashad.domain.authentication.repositories

import com.rashad.domain.authentication.common.MadrastyResponseModel
import com.rashad.domain.authentication.models.CategoryModel
import com.rashad.domain.authentication.models.OptionChildModel
import io.reactivex.Single


interface AuthenticationRepository {


  fun getAllCats( ): Single<CategoryModel>
  fun getOptionsChildById( id :String ): Single<List<OptionChildModel>>
  fun propertiesById( id :String ): Single<List<OptionChildModel>>


}