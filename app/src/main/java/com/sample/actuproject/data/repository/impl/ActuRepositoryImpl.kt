package com.sample.actuproject.data.repository.impl

import com.sample.actuproject.api.service.ApiActuService
import com.sample.actuproject.data.model.Actu
import com.sample.actuproject.data.model.RootObject
import com.sample.actuproject.data.model.Success
import com.sample.actuproject.data.repository.contract.ActuRepository
import io.reactivex.Single

object ActuRepositoryImpl : ActuRepository {


    override fun loadEvents(apiService: ApiActuService): Single<List<Actu>> {
        return apiService.loadEvents()
    }

    override fun signUp(apiService: ApiActuService, name: String, mail: String, telephone: String): Single<RootObject> {
        return apiService.signUp(name, mail, telephone,"picture")
    }


}