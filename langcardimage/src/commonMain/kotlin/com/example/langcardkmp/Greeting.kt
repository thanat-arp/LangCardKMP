package com.example.langcardkmp

class OSPlatform {
    private val platform: Platform = getPlatform()

    fun getName(): String {
        return "0.0.1 First Say Hi to ${platform.name}!"
    }
}