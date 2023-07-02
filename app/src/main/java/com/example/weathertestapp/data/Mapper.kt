package com.example.weathertestapp.data

import com.example.weathertestapp.data.model.weathermodel.ApiForecastModel
import com.example.weathertestapp.data.model.weathermodel.Entity
import com.example.weathertestapp.domain.model.fivedaymodel.FiveDayModel

class Mapper {

    fun apiModelToDomainModel(entity: Entity): FiveDayModel {
        return FiveDayModel(
            date = entity.dt_txt,
            temp = entity.main.temp.toString()
        )
    }

    fun listApiModelToListDomainModel(apiForecastModel: ApiForecastModel): List<FiveDayModel> {
        return apiForecastModel.list.map { apiModelToDomainModel(it) }
    }
}