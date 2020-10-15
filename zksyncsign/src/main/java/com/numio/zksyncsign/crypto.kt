package com.numio.zksyncsign

import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

external fun privateKeyToPublicKeyHash(input: String): String
external fun privateKeyFromSeed(input: String): String
external fun signTransactionBytes(private_key: String, txn_bytes: String): String

fun loadZkSync() {
	System.loadLibrary("zksyncsign")
}

//class Crypto: ViewModel() {
//
//	fun login(input: String): String {
//		// Create a new coroutine to move the execution off the UI thread
//		viewModelScope.launch(Dispatchers.IO) {
//			callPKeyToPubKeyHash(input: String)
//		}
//	}
//}

private fun logThread(methodName: String) {
	println("debug: ${methodName}: ${Thread.currentThread().name}" )
}

@WorkerThread
suspend fun callPKeyToPubKeyHash(input: String): String = withContext(Dispatchers.Default) {
	privateKeyToPublicKeyHash(input)
}

@WorkerThread
suspend fun callPrivateKeyFromSeed(input: String): String = withContext(Dispatchers.Default) {
	privateKeyFromSeed(input)
}

@WorkerThread
suspend fun callSignTransactionBytes(private_key: String, txn_bytes: String): String =
	withContext(Dispatchers.Default) {
		signTransactionBytes(private_key, txn_bytes)
	}

//class Crypto {
//	private val scope = CoroutineScope(Job() + Dispatchers.Main)
//
//	fun callCrypto(input: String): String {
//		val defaultScopedJob = scope.launch(Dispatchers.Default) {
//			val result = try {
//			} catch (e: Exception) {
//				throw e
//			}
//
//			when (pubKeyHash) {
//				return pubKeyHash
//			}
//		}
//	}
//
//	suspend fun callPKeyToPubKeyHash(input: String): String = withContext(Dispatchers.Default) {
//		privateKeyToPublicKeyHash(input)
//
//	}
//}