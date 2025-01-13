package com.example.langcardkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform