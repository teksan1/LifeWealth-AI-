package com.lifewealthai.report

import android.content.Context
import java.io.File

object ReportGenerator {

    fun generateMonthlyReport(context: Context, content: String): File {
        val file = File(context.filesDir, "monthly_report.txt")
        file.writeText(content)
        return file
    }
}
