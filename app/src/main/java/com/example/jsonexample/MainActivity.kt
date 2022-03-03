package com.example.jsonexample

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.internal.ContextUtils.getActivity
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    var users=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

init()
    }
fun init() {
    val text = findViewById<TextView>(R.id.name)
    var textOne = findViewById<TextView>(R.id.nameOne)
    val obj = JSONObject(this.loadJSONFromAsset())
    val userArray = obj.getJSONArray("users")

    val userDetail = userArray.getJSONObject(0)
users=userDetail.getString("1")
val usersOne=userDetail.getString("2")
    text.setText(users)
    textOne.setText(usersOne)
}
//@SuppressLint("RestrictedApi")
fun Context.loadJSONFromAsset():String{
//    val t = getActivity(this@MainActivity)!!.assets.openRawResourse("imp.json")
val t = resources.openRawResource(R.raw.imp)
    val size = t.available()
    val buffer=ByteArray(size)
    t.read(buffer)
    t.close()
    return String(buffer, Charsets.UTF_8)
}

}