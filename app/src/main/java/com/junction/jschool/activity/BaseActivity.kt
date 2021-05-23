package com.junction.jschool.activity

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gcode.gutils.utils.ActivityCollectorUtils

open class BaseActivity : AppCompatActivity() {

    private lateinit var receiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollectorUtils.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.nfc.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollectorUtils.removeActivity(this)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("Warning")
                setMessage("密码错误,请重新输入")
                setCancelable(false) //设置对话框不可以取消
                setPositiveButton("OK") { _, _ ->
                    ActivityCollectorUtils.finishAll() // 销毁所有Activity
                    val i = Intent(context, StartActivity::class.java)
                    context.startActivity(i) // 重新启动LoginActivity
                }
                show()
            }
        }
    }
}
