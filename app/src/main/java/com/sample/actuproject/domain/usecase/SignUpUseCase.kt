package com.sample.actuproject.domain.usecase

import com.sample.actuproject.api.service.ApiActuService
import com.sample.actuproject.base.usecase.SingleUseCase
import com.sample.actuproject.data.model.Success
import com.sample.actuproject.data.repository.contract.ActuRepository
import com.sample.actuproject.data.repository.impl.ActuRepositoryImpl
import io.reactivex.Single


class SignUpUseCase(
    private val apiService: ApiActuService,
    private val name: String,
    private val mail: String,
    private val telephone: String
) : SingleUseCase<Success> {

    override fun execute(): Single<Success> =
        (ActuRepositoryImpl as ActuRepository).signUp(apiService, name, mail, telephone).map {
            return@map it.success
        }

}