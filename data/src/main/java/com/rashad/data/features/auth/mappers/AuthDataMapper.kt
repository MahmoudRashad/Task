package com.rashad.data.features.auth.mappers

import com.rashad.data.features.auth.responses.CategoryRemote
import com.rashad.data.features.auth.responses.OptionsChildRemote
import com.rashad.domain.authentication.models.CategoryModel
import com.rashad.domain.authentication.models.OptionChildModel

fun CategoryRemote.mapToCategoryRemoteModel(): CategoryModel =
    CategoryModel(
        id = id ,
                name = name ,
                description = description ,
                image = image ,
                slug = slug ,
                children = children?.map {
                                       it.mapToChildrensCategoryModel()
                } ,
                circleIcon = circleIcon ,
                disableShipping = disableShipping ,
    )
fun OptionsChildRemote.mapToOptionsChildModel(): OptionChildModel =
    OptionChildModel(
        id = id ,
                name = name ,
                description = description ,
                slug = slug ,
                parent = parent ,
                list = list ,
                type = type ,
                value = value ,
                otherValue = otherValue ,
                options = options ?.map {
                                       it.mapToOptionModel()
                } ,
    )

fun OptionsChildRemote.OptionRemote.mapToOptionModel() :OptionChildModel.OptionModel =
    OptionChildModel.OptionModel(
        id= id ,
                name= name ,
                slug= slug ,
                parent= parent ,
                child= child ,
    )

fun CategoryRemote.ChildrensCategoryRemote.mapToChildrensCategoryModel(): CategoryModel.ChildrensCategoryModel=
    CategoryModel.ChildrensCategoryModel(
        id = id ,
                name = name ,
                description = description ,
                image = image ,
                slug = slug ,
                children = children ,
                circleIcon = circleIcon ,
                disableShipping  = disableShipping ,
    )