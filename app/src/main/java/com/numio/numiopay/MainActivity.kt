package com.numio.numiopay

import com.numio.zksyncsign.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.coroutines.*
import androidx.annotation.MainThread
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mnem = "mobile radio dentist close young link urge snack casino online draft trick ritual room trophy"
        loadZkSync()

        val hexPrivateKey = "0166c0b613d99406d577ebbb582ede3086ce86423d0a61f4c3864d2ca392f496"
        val hexSeed = "199659b1c85eb4048e5d47620669492f6ed38194530e023d8c8e161aa72db3a32ebec7e33bbe7bec10a61531c87595bd15681ad1756cb1a74d6426e0b513cd151c"
        val correctPubKeyHash = "7731c2c99f46cc2f7f5e564ffd8f5e17e0a8160b"

        button.setOnClickListener {
//            runBlocking {
//                val result = privateKeyFromSeed(hexSeed)
//                var hexResult = ""
//                for (b in result) {
//                    val st = String.format("%02X", b)
//                    hexResult += st
//                }
                val pubKeyHash = signTransactionBytes(hexPrivateKey, hexSeed)

//                Log.d("debug", "callPrivateKeyFromSeed")
//                Log.d("debug", result)
                Log.d("debug", "pubKeyHash")
                Log.d("debug", pubKeyHash)
//                Log.d("debug", "hexResult")
//                Log.d("debug", hexResult)
//            }
        }
    }
}