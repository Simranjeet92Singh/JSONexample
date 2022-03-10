package com.example.jsonexample

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.internal.ContextUtils.getActivity
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    private  val NUM_PAGES = 10
//    var k : Int= 0

    private var mPager:androidx.viewpager.widget.ViewPager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    mPager = findViewById<androidx.viewpager.widget.ViewPager>(R.id.viewPager)

        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager!!.adapter = pagerAdapter



    }
    override fun onBackPressed() {
        if (mPager!!.currentItem == 0) {
            super.onBackPressed()
        } else {
            mPager!!.currentItem = mPager!!.currentItem - 1
        }
    }
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUM_PAGES

        override fun getItem(position: Int): Fragment {




            var k = position*2
            var i = 0..NUM_PAGES
            when (i) {
                i -> {

     return MainActivity2(k,k+1)


                }




            }
            if (NUM_PAGES == 9){
                MainActivity2(17,18)
            }
     return MainActivity2(0,3)

        }
    }
}


