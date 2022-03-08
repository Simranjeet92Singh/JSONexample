package com.example.jsonexample

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private  val NUM_PAGES = 3
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
            when (position) {
                0 -> return MainActivity2(0,3)
                1 -> return MainActivity2(4,7)
                2 -> return MainActivity2(8,9)

            }
     return MainActivity2(0,3)

        }
    }
}



////val fragment = findViewById<androidx.fragment.app.FragmentContainerView>(R.id.fragment)
//        val floatingActionButton =
//            findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingButton)
//
////    val homeFragment = MainActivity2()
//
//
//        val fragmentOne = MainActivity2()
//        val fragmentManager = supportFragmentManager
//
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragment, fragmentOne)
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.commit()
////val i = intent.extras
////val p = i!!.getString("Key")
////        val args = Bundle()
////        args.putString("Key","1")
////        fragmentOne.arguments=args
//
//
//   floatingActionButton.setOnClickListener{
//       val fragmentOne = MainActivtiyThree()
//       val fragmentManager = supportFragmentManager
//
//       val fragmentTransaction = fragmentManager.beginTransaction()
//       fragmentTransaction.replace(R.id.fragment, fragmentOne)
//       fragmentTransaction.addToBackStack(null)
//       fragmentTransaction.commit()
//
//
//   }
//
//    }
//}