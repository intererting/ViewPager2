package com.yuliyang.viewpager2

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.buildSpannedString
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_test.*
import org.jetbrains.anko.Bold
import org.jetbrains.anko.append
import org.jetbrains.anko.buildSpanned

class SecondActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_test)
//        button.setOnClickListener {
//            viewModel.name = "SecondActivity"
//            println(viewModel.name)
//        }

        buildSpannedString {
            append("",Bold)
        }
    }

    override fun onResume() {
        super.onResume()
        println(viewModel.name)
        println("$this")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }
}