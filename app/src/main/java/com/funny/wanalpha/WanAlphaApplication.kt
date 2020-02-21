package com.funny.wanalpha

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.funny.common.network.HttpManager

class WanAlphaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //初始化网络逻辑
        HttpManager.init()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}