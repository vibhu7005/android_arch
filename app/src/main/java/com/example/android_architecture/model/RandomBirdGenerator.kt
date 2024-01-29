package com.example.android_architecture.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RandomBirdGenerator {
    companion object {
        val scope = CoroutineScope(Dispatchers.IO)
        suspend fun generateBird() : Bird {
            delay(1000)
            return Bird("atalasian", (0 ..100).random())
        }
    }
}