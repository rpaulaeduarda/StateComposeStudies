package com.example.statecomposestudies

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel: ViewModel() {

    // cria uma lista mutável e observável que nao pode ser modificada fora da ViewModel
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        tasks.find { it.id == task.id }?.let { task ->
            task.checked = checked
        }
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
