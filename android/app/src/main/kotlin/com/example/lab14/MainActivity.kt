package com.example.lab14

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.example/native_demo_app"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        // Ініціалізація каналу методів
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->
            // Перевіряємо, який метод викликано
            if (call.method == "getStaticString") {
                result.success("Hi, Mom!") // Повертаємо відповідь
            } else {
                result.notImplemented() // Якщо метод не реалізовано
            }
        }
    }
}
