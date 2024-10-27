package com.example.model

class TaskRepositoryImpl: TaskRepository {

    private var tasksList = mutableListOf(
        Task("cleaning", "Clean the house", Priority.Low),
        Task("gardening", "Mow the lawn", Priority.Medium),
        Task("shopping", "Buy the groceries", Priority.High),
        Task("painting", "Paint the fence", Priority.Medium)
    )

    override suspend fun getAll(): List<Task> {
        return tasksList
    }

    override suspend fun getTaskByPriority(priority: Priority): List<Task> {
        return tasksList.filter {
            it.priority == priority
        }
    }

    override suspend fun getTaskByName(name: String): Task? {
        return tasksList.find{
            it.name.equals(name, ignoreCase = true)
        }
    }

    override suspend fun addTask(task: Task) {
        if (getTaskByName(task.name) != null){
            throw IllegalArgumentException("Duplicate name")
        }
    }

    override suspend fun deleteTask(name: String): Boolean {
        return tasksList.removeIf { it.name == name }
    }

}