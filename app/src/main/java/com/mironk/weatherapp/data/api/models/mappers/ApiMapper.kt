package com.mironk.weatherapp.data.api.models.mappers

interface ApiMapper<Domain, Entity> {
    fun mapToDomain(apiEntity: Entity): Domain
}