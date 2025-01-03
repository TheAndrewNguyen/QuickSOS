package com.example.quicksos.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

//function to call a number
fun callNumber(context: Context, number: String) {
    Log.d("PhoneUtils", "Calling $number")

    val uri = Uri.parse("tel:$number")
    val intent = Intent(Intent.ACTION_DIAL, uri)
    try {
        context.startActivity(intent)
    } catch(e: Exception) {
        Log.w("PhoneUtils", "Error launching dialer")
    }
}

//function to text individual number
//TODO: send without confirmation
fun textNumber(context: Context, number: String, message: String) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("smsto:$number")
        putExtra("sms_body", message)
    }

    context.startActivity(intent)
}

fun textMultipleNumbers(context: Context, numbers: List<String>, message: String) {
    numbers.forEach {element->
        textNumber(context, element, message)
    }
}
