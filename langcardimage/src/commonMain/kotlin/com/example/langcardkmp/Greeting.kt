package com.example.langcardkmp

class OSPlatform {
    private val platform: Platform = getPlatform()

    fun getName(): String {
        return "0.0.2 version of ${platform.name}!"
    }
}