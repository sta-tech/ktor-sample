package ru.statech

import com.typesafe.config.ConfigBeanFactory
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.Configuration
import org.jooq.SQLDialect
import org.jooq.conf.RenderQuotedNames
import org.jooq.conf.Settings
import org.jooq.impl.DefaultConfiguration
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.statech.services.TodoService
import ru.statech.services.TodoServiceImpl
import ru.statech.services.JooqTodosRepositoryImpl
import ru.statech.services.TodosRepository
import javax.sql.DataSource

val appModule = module {
    val config = ConfigFactory.load()
    var databaseConfig = ConfigBeanFactory.create(config.getConfig("database"), DatabaseConfig::class.java)

    single { databaseConfig }

    val hikariDatasource = HikariDataSource(
        HikariConfig().apply {
            username = databaseConfig.user
            password = databaseConfig.password
            poolName = "main"
            maximumPoolSize = 10
            dataSourceClassName = "org.postgresql.ds.PGSimpleDataSource"
            addDataSourceProperty("url", databaseConfig.url)
        }
    )

    single { hikariDatasource } bind DataSource::class

    val jooqConfig =  DefaultConfiguration().apply {
        setDataSource(hikariDatasource)
        setSQLDialect(SQLDialect.POSTGRES)
        setSettings(Settings().withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED))
    }

    single { jooqConfig } bind Configuration::class

    singleOf(::TodoServiceImpl) bind TodoService::class

    singleOf(::JooqTodosRepositoryImpl) bind TodosRepository::class
}