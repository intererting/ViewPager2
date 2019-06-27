package com.yuliyang.viewpager2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModels = hashMapOf<String, TestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testFragments = arrayListOf<Fragment>()
        for (i in 0..10) {
            val data = bundleOf("data" to i + 100)
            testFragments.add(TestFragment().apply {
                this@MainActivity.supportFragmentManager.registerFragmentLifecycleCallbacks(object :
                    FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
                        super.onFragmentAttached(fm, f, context)
                        if (!viewModels.containsKey(f.tag) && f.tag != null) {
                            viewModels.put(
                                f.tag!!,
                                ViewModelProviders.of(f).get(TestViewModel::class.java)
                            )
                        }
//                        viewModels.add(ViewModelProviders.of(f).get(TestViewModel::class.java))
                    }
                }, false)
                arguments = data
            })
        }
        val myAdapter = ViewPagerAdapter(this)
        myAdapter.mFragments = testFragments
        viewPager.adapter = myAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                println("${viewModels["f$position"]}")
//                println("${viewModels["f$position"]?.name}")
            }
        })
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

        var mFragments = arrayListOf<Fragment>()

        override fun getItemCount(): Int {
            return mFragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return mFragments[position]
        }

    }
}
