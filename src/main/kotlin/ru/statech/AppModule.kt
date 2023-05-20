package ru.statech

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.statech.services.TodoService
import ru.statech.services.TodoServiceImpl

val appModule = module {
    singleOf(::TodoServiceImpl) {
        bind<TodoService>()
    }
}