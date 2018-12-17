package com.sample.actuproject.data.repository.contract

import com.sample.actuproject.api.service.ApiActuService
import com.sample.actuproject.data.model.Actu
import com.sample.actuproject.data.model.RootObject
import com.sample.actuproject.data.model.Success
import io.reactivex.Single

interface ActuRepository {

    fun loadEvents(apiService: ApiActuService) : Single<List<Actu>>

    fun signUp(apiService: ApiActuService, name : String, mail : String, telephone : String) : Single<RootObject>
}