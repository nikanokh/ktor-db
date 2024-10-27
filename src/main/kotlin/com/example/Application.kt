package com.example

import com.example.model.PostgresTaskRepository
import com.example.model.TaskRepositoryImpl
import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val repository = PostgresTaskRepository()
//    val repository = TaskRepositoryImpl()
    configureSerialization(repository)
    configureDatabases()
    configureRouting()
}
