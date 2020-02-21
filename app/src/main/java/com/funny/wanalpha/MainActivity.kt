package com.funny.wanalpha

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_main).setOnClickListener({
            ARouter.getInstance().build("/main/mainview").navigation()
            }
        )

        findViewById<Button>(R.id.btn_square).setOnClickListener({
            ARouter.getInstance().build("/square/square").navigation()
        }
        )

        findViewById<Button>(R.id.btn_tree).setOnClickListener({
            ARouter.getInstance().build("/tree/tree").navigation()
        }
        )

    }

}
