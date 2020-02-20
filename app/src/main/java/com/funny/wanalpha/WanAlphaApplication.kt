package com.funny.wanalpha

import android.app.Application
import com.funny.common.network.HttpManager

class WanAlphaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //初始化网络逻辑
        HttpManager.init()
    }
}