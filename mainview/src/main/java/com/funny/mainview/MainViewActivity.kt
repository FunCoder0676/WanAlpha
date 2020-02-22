package com.funny.mainview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.funny.common.util.obtainViewModel
import com.funny.common.util.repalceFragment

@Route(path = "/main/mainview")
class MainViewActivity : AppCompatActivity() {

    lateinit var mmainViewModel: MmainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mmainViewModel = obtainViewModel(this, MmainViewModel::class.java)

        setContentView(R.layout.activity_mainview)

        repalceFragment(
            supportFragmentManager,
            findOrCreateViewFragment(), R.id.container
        )
    }


    private fun findOrCreateViewFragment() = MmainFragment()

}