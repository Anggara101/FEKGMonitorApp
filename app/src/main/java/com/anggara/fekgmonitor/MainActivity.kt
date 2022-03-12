package com.anggara.fekgmonitor

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAdapter.getDefaultAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.anggara.fekgmonitor.ui.theme.FEKGMonitorTheme
import java.io.IOException
import java.util.*

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private val MyUUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    private val bluetoothAdapter: BluetoothAdapter = getDefaultAdapter()
    private lateinit var socket:BluetoothSocket
    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Log.i("Bluetooth", ":request permission result ok")
            val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter?.bondedDevices
            pairedDevices?.forEach { device ->
                val deviceName = device.name
                val deviceHardwareAddress = device.address // MAC address
                Log.i("Bluetooth", deviceName)
                if (deviceName=="raspberrypi"){
                    socket = device.createRfcommSocketToServiceRecord(MyUUID)
                    socket.connect()
                    Log.i("Bluetooth", "Connecting to raspberypi")
                }
            }
        } else {
            Log.i("Bluetooth", ":request permission result canceled / denied")
        }
    }
    private fun requestBluetoothPermission() {
        val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        activityResultLauncher.launch(enableBluetoothIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!bluetoothAdapter.isEnabled) {
            requestBluetoothPermission()
        }


        setContent {
            FEKGMonitorTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        socket.close()
    }
}
