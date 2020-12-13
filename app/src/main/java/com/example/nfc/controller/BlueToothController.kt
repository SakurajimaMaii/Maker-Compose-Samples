/*
*蓝牙控制
*@author 泷
*created at 2020/9/22 7:41
*/
package com.example.nfc.controller

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import androidx.databinding.library.BuildConfig
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


object BlueToothController {

    private var mAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    fun getAdapter(): BluetoothAdapter? {
        return mAdapter
    }

    /**
    *判断是否支持蓝牙
    * @return true支持 false不支持
    */
    //fun isSupportBlueTooth():Boolean = (mAdapter!=null)

    /**
    *判断当前蓝牙状态
    * @return true 打开 false关闭
    */
    fun getBlueToothStatus():Boolean = mAdapter?.isEnabled ?:false

    /**
     * 打开蓝牙
     * @param activity Activity
     * @param requestCode Int
     */
    fun turnOnBlueTooth(activity: FragmentActivity, requestCode: Int){
        val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        activity.startActivityForResult(intent, requestCode)
    }

    /**
     * 打开蓝牙可见性
     * @param context Context
     */
    fun enableVisibly(context: Fragment){
        val discoverableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300) //设置时长为5分钟
        context.startActivity(discoverableIntent)
    }

    /**
     * 查找设备
     */
    fun findDevice() {
        if (BuildConfig.DEBUG && mAdapter == null) {
            error("Assertion failed")
        }
        mAdapter?.startDiscovery()
    }

    fun getBondedDeviceList():List<BluetoothDevice>{
        val devices:MutableList<BluetoothDevice> = ArrayList()
        for(device in mAdapter?.bondedDevices!!){
            devices.add(device)
        }
        return devices
    }

    /**
    *关闭蓝牙
    */
    fun turnOffBlueTooth(){
        mAdapter?.disable()
    }
}