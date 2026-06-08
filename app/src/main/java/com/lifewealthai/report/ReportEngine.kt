package com.lifewealthai.report

import android.content.Context
import java.io.File

object ReportEngine {

    fun generate(context: Context, summary: String): File {
        val file = File(context.filesDir, "finance_report.txt")
        file.writeText(summary)
        return file
    }
}
