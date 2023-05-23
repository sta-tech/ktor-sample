package ru.statech

import kotlin.properties.Delegates

class DatabaseConfig {
    var user: String by Delegates.notNull()
    var password: String by Delegates.notNull()
    var url: String by Delegates.notNull()
}