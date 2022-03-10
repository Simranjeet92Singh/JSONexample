package com.example.jsonexample

import android.content.Intent
import android.content.res.AssetManager
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject
import java.util.*


class MainActivity2(val t: Int, val s: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main2, container, false)

        val text = view.findViewById<TextView>(R.id.textViewOne) as TextView
        var textOne = view.findViewById<TextView>(R.id.textViewTwo)
        var textTwo = view.findViewById<TextView>(R.id.textViewThree)
        var textThree = view.findViewById<TextView>(R.id.textViewFour)


        val face = Typeface.createFromAsset(requireContext().assets, "GurbaniWebThick.ttf")
        text.setTypeface(face)
        textTwo.setTypeface(face)

        for (i in t..s) {
//if (s  throw ArrayIndexOutOfBoundsException){
//
//}
            val obj = JSONObject(loadJSONFromAsset())
            val objOne = obj.getJSONArray("Ardass")
            val userArray = objOne.getJSONObject(i)

            if(userArray == null){
                     text.setText("")
                     textTwo.setText("")
                    textThree.setText("")
                textOne.setText("")

                }else{
                val userArrayOne = userArray.getJSONArray("lines")
                val userDetail =
                    userArrayOne.getJSONObject(0).getJSONObject("gurmukhi").getString("SGPC")
                val userDetailEnglish =
                    userArrayOne.getJSONObject(0).getJSONObject("translations").getJSONObject("English")
                        .getJSONObject("SGPC").getString("translation")
                when (i) {
                    t -> text.setText(userDetail)
                    t + 1 -> textTwo.setText(userDetail)

                }
                when (i) {
                    t -> textOne.setText(userDetailEnglish)
                    t + 1 -> textThree.setText(userDetailEnglish)

                }


            }
//            val userArrayOne = userArray.getJSONArray("lines")
//            val userDetail =
//                userArrayOne.getJSONObject(0).getJSONObject("gurmukhi").getString("SGPC")
//            val userDetailEnglish =
//                userArrayOne.getJSONObject(0).getJSONObject("translations").getJSONObject("English")
//                    .getJSONObject("SGPC").getString("translation")

        }


        return view
    }

    fun loadJSONFromAsset(): String {
        val t = resources.openRawResource(R.raw.ardas)
        val size = t.available()
        val buffer = ByteArray(size)
        t.read(buffer)
        t.close()
        return String(buffer, Charsets.UTF_8)
    }
}
