package com.bshpanchuk.apimocker.common.di

import com.bshpanchuk.apimocker.data.RepositoryImpl
import com.bshpanchuk.apimocker.domain.Repository
import org.koin.dsl.module

val dataModule = module {
    single<Repository> { RepositoryImpl(get()) }
}