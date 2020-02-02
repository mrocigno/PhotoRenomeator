package br.com.mrocigno.domain.usecase

import br.com.mrocigno.domain.entity.Guide

interface GuideUseCase {

    suspend fun getServicesByGuideName(name: String): List<Guide>

}