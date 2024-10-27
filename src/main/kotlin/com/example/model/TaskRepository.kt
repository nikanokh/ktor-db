package com.example.model

interface TaskRepository{
    suspend fun getAll(): List<Task>
    suspend fun getTaskByPriority(priority: Priority): List<Task>
    suspend fun getTaskByName(name: String): Task?
    suspend fun addTask(task: Task)
    suspend fun deleteTask(name: String): Boolean
}

