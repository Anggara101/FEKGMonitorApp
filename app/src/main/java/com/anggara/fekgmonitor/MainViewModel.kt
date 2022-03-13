package com.anggara.fekgmonitor

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

//    val uuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

    private val _homeSubTitle: MutableLiveData<String> = MutableLiveData("Press start button to start")
    val homeSubTitle: LiveData<String>
        get() = _homeSubTitle

    init {
        if (!bluetoothAdapter.isEnabled){
            Log.i("Bluetooth", "Bluetooth is disabled")
            _homeSubTitle.value = "Bluetooth is disabled, please enable Bluetooth"
        } else{
            Log.i("Bluetooth", "Bluetooth is enabled")
            _homeSubTitle.value = "Bluetooth is enabled"

            val pairedDevices: Set<BluetoothDevice> = bluetoothAdapter.bondedDevices
            pairedDevices?.forEach { device ->
                val deviceName = device.name
                val deviceHardwareAddress = device.address // MAC address
            }
        }
    }


    fun onButtonStartClick(
        bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter(),
    ){
        if (!bluetoothAdapter.isEnabled){
            Log.i("Bluetooth", "Bluetooth is disabled, please enable Bluetooth")
            _homeSubTitle.value = "Bluetooth is disabled, please enable Bluetooth"
        } else{
            Log.i("Bluetooth", "Bluetooth is enabled")
            _homeSubTitle.value = "Bluetooth is enabled"

        }
    }
}