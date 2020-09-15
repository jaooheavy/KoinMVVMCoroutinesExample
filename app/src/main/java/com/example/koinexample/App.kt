package com.example.koinexample

import MainViewModel
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }


    //Modulo Inject Koin
    val appModule = module {
        //Cria a instancia do RequestAPI
        factory { RequestAPI() }

        //Cria instancia do ViewModel e ja passa o utils no metodo get()
        single { MainViewModel(get()) }
    }
}


