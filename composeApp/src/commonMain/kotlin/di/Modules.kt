package di

import dependencies.DbClient
import dependencies.MyRepository
import dependencies.MyRepositoryImpl
import dependencies.MyViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
//    single { MyRepositoryImpl(get()) }.bind<MyRepository>()
    singleOf(::MyRepositoryImpl).bind<MyRepository>()
    viewModelOf(::MyViewModel)
}