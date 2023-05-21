package ru.statech

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.statech.services.TodoService
import ru.statech.services.TodoServiceImpl
import ru.statech.services.JooqTodosRepositoryImpl
import ru.statech.services.TodosRepository

val appModule = module {
    singleOf(::TodoServiceImpl) bind TodoService::class

    singleOf(::JooqTodosRepositoryImpl) bind TodosRepository::class
}