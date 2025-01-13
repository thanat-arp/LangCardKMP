package com.example.langcardkmp

class OSPlatform {
    private val platform: Platform = getPlatform()

    fun getName(): String {
        return "First Say Hi to ${platform.name}!"
    }
}