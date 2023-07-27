package com.appcenter.favor

import android.app.Application

class App: Application() {
    companion object{
        lateinit var userData : UserData
    }

    override fun onCreate() {
        userData = UserData(applicationContext)
        super.onCreate()
    }

}