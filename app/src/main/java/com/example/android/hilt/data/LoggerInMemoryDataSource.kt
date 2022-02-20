package com.example.android.hilt.data

import java.util.*
import javax.inject.Inject

/**
 * Class to swap the log storage from a database to an in-memory list with the intention of only
 * recording the logs during an app session.
 */
class LoggerInMemoryDataSource @Inject constructor(): LoggerDataSource {
    private val logs = LinkedList<Log>()

    override fun addLog(msg: String) {
        logs.addFirst(Log(msg, System.currentTimeMillis()))
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback(logs)
    }

    override fun removeLogs() {
        logs.clear()
    }
}