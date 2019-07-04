package com.yuliyang.viewpager2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.android.synthetic.main.item_test.view.*

class TestFragment : Fragment() {

    private val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println("onCreate")
    }

    private val adapter by lazy {
        TestAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState == null) {
            testRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            testRecyclerView.adapter = TestAdapter()
        } else {
            testRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            testRecyclerView.adapter = TestAdapter()
        }

    }

    override fun onResume() {
        super.onResume()
//        viewModel.name = arguments?.getInt("data").toString()
//        button.setOnClickListener {
//            test.text = "after click"
//            viewModel.name = "hahahahahha"
//            startActivity(Intent(requireContext(), SecondActivity::class.java))
//            test.text = viewModel.name
//            println("$viewModel")
//        }
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

    class TestAdapter : RecyclerView.Adapter<TestHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
            return TestHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false))
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: TestHolder, position: Int) {
            holder.itemView.text.text = position.toString()
        }

    }

    class TestHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class TestAdapterB : RecyclerView.Adapter<TestHolderB>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolderB {
            return TestHolderB(LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false))
        }

        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(holder: TestHolderB, position: Int) {
            holder.itemView.text.text = position.toString()
        }

    }

    class TestHolderB(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}