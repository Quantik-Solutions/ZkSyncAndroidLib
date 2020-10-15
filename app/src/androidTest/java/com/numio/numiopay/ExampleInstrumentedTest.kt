package com.numio.numiopay

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.numio.zksyncsign.callPKeyToPubKeyHash
import com.numio.zksyncsign.callPrivateKeyFromSeed
import com.numio.zksyncsign.loadZkSync
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.numio.numiopay", appContext.packageName)
    }
    val hexPrivateKey = "0x0166c0b613d99406d577ebbb582ede3086ce86423d0a61f4c3864d2ca392f496"
    private val hexSeed =
        "0x199659b1c85eb4048e5d47620669492f6ed38194530e023d8c8e161aa72db3a32ebec7e33bbe7bec10a61531c87595bd15681ad1756cb1a74d6426e0b513cd151c"
    private val correctPubKeyHash = "0x7731c2c99f46cc2f7f5e564ffd8f5e17e0a8160b"

    init {
        loadZkSync()
    }

    @Test
    fun testPrivateKeyToPubKeyHash() {
        runBlocking {
            val result = callPrivateKeyFromSeed(hexSeed)
            var hexResult = ""
            for (b in result) {
                val st = String.format("%02X", b)
                hexResult += st
            }
            assertEquals(correctPubKeyHash, hexResult)

        }
    }

    @Test
    fun testCallPKeyToPubKeyHash() {
        runBlocking {
            val result = callPKeyToPubKeyHash(hexPrivateKey)
            assertEquals(correctPubKeyHash, result)
        }
    }
}