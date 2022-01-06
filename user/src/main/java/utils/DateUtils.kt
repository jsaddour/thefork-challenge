package utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

object DateUtils {
    fun parseDate(date: String): Date {
        val parser =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return parser.parse(date)
    }

    fun formatDate(date: Date): String{
        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        return simpleDateFormat.format(date)
    }
}