package com.example.jsonexample

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.internal.ContextUtils.getActivity
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//val fragment = findViewById<androidx.fragment.app.FragmentContainerView>(R.id.fragment)
        val floatingActionButton =
            findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingButton)

//    val homeFragment = MainActivity2()


        val fragmentOne = MainActivity2()
        val fragmentManager = supportFragmentManager

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragmentOne)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
//val i = intent.extras
//val p = i!!.getString("Key")
//        val args = Bundle()
//        args.putString("Key","1")
//        fragmentOne.arguments=args


   floatingActionButton.setOnClickListener{
       val fragmentOne = MainActivity2()
       val fragmentManager = supportFragmentManager

       val fragmentTransaction = fragmentManager.beginTransaction()
       fragmentTransaction.replace(R.id.fragment, fragmentOne)
       fragmentTransaction.addToBackStack(null)
       fragmentTransaction.commit()


   }

    }
}