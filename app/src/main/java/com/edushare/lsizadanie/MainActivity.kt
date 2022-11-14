package com.edushare.lsizadanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import  com.edushare.lsizadanie.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).run {
            setContentView(root)
        }
    }
}