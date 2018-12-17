package com.sample.actuproject.domain.usecase

import com.sample.actuproject.api.service.ApiActuService
import com.sample.actuproject.base.usecase.SingleUseCase
import com.sample.actuproject.data.model.Actu
import com.sample.actuproject.data.repository.contract.ActuRepository
import com.sample.actuproject.data.repository.impl.ActuRepositoryImpl
import io.reactivex.Single

class LoadEventsUseCase(private val apiService: ApiActuService) : SingleUseCase<List<Actu>> {

    override fun execute(): Single<List<Actu>> = (ActuRepositoryImpl as ActuRepository).loadEvents(apiService).map {
        return@map it
    }

}