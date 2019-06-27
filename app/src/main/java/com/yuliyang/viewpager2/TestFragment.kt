package com.yuliyang.viewpager2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : Fragment() {

    private val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println("onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel.name = arguments?.getInt("data").toString()
        button.setOnClickListener {
            //            test.text = "after click"
//            viewModel.name = "hahahahahha"
//            startActivity(Intent(requireContext(), SecondActivity::class.java))
//            test.text = viewModel.name
            println("$viewModel")
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        println("onDestroyView")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
//        println("onDestroy")
    }
}