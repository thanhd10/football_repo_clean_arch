package com.example.football_exp

import android.app.Application
import com.example.football_exp.core.di.Injector

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Injector.init(this)
    }
}