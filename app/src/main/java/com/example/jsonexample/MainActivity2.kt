package com.example.jsonexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject

class MainActivity2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
    val view = inflater.inflate(R.layout.activity_main2,container,false)

//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////    var users = ""

    val text = view.findViewById<TextView>(R.id.name) as TextView
    var textOne = view.findViewById<TextView>(R.id.nameOne)
    val obj = JSONObject(loadJSONFromAsset())
    val userArray = obj.getJSONArray("users")

    val userDetail = userArray.getJSONObject(0)
     val users = userDetail.getString("1")
    val usersOne = userDetail.getString("2")
    text.setText(users)
    textOne.setText(usersOne)
return view
    }

    fun loadJSONFromAsset(): String {
//    val t = getActivity(this@MainActivity)!!.assets.openRawResourse("imp.json")
        val t = resources.openRawResource(R.raw.imp)
        val size = t.available()
        val buffer = ByteArray(size)
        t.read(buffer)
        t.close()
        return String(buffer, Charsets.UTF_8)
    }
}

//}
//    var users=""
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//        init()
//    }
//    fun init() {
//        val text = findViewById<TextView>(R.id.name)
//        var textOne = findViewById<TextView>(R.id.nameOne)
//        val obj = JSONObject(this.loadJSONFromAsset())
//        val userArray = obj.getJSONArray("users")
//
//        val userDetail = userArray.getJSONObject(0)
//        users=userDetail.getString("1")
//        val usersOne=userDetail.getString("2")
//        text.setText(users)
//        textOne.setText(usersOne)
//    }
//    //@SuppressLint("RestrictedApi")
//    fun Context.loadJSONFromAsset():String{
////    val t = getActivity(this@MainActivity)!!.assets.openRawResourse("imp.json")
//        val t = resources.openRawResource(R.raw.imp)
//        val size = t.available()
//        val buffer= ByteArray(size)
//        t.read(buffer)
//        t.close()
//        return String(buffer, Charsets.UTF_8)
//    }
//
//}