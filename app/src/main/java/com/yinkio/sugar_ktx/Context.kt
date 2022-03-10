package com.yinkio.sugar_ktx

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.os.BatteryManager
import android.os.PowerManager

fun Context.alarmManager() : AlarmManager{
    return getSystemService(Context.ALARM_SERVICE) as AlarmManager
}

fun Context.notificationManager() : NotificationManager{
    return getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
}

fun Context.batteryManager() : BatteryManager{
    return getSystemService(Context.BATTERY_SERVICE) as BatteryManager
}

fun Context.powerManager() : PowerManager{
    return getSystemService(Context.POWER_SERVICE) as PowerManager
}
