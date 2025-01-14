package com.organizely.app.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "AllTasks")
data class TaskItem(
    @ColumnInfo(name = "task_name")
    var taskName: String?,
    @ColumnInfo(name = "task_completed")
    var isCompleted: Boolean?,
    @ColumnInfo(name = "task_category")
    var category: String?,
    @ColumnInfo(name = "task_due")
    var dueDate: String?,
    @ColumnInfo(name = "task_repeated")
    var isRepeated: Boolean,
    @ColumnInfo(name = "task_notes")
    var taskNotes: String?
) {

}