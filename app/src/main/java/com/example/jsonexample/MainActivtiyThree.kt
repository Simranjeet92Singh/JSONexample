package com.example.jsonexample

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject

class MainActivtiyThree: Fragment() {
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



        val face = Typeface.createFromAsset(requireContext().assets,"GurbaniWebThick.ttf")
        text.setTypeface(face)
        textOne.setTypeface(face)
        textTwo.setTypeface(face)
        textThree.setTypeface(face)

        for (i in  4.. 8){

            val obj = JSONObject(loadJSONFromAsset())
            val objOne = obj.getJSONArray("Ardass")

            val userArray = objOne.getJSONObject(i)
            val userArrayOne = userArray.getJSONArray("lines")
            val userDetail = userArrayOne.getJSONObject(0).getJSONObject("gurmukhi").getString("SGPC")
            when(i){
                4->     text.setText(userDetail)
                5->      textOne.setText(userDetail)
                6->      textTwo.setText(userDetail)
                7->      textThree.setText(userDetail)

            }
        }

//        var value = "1"
//        var value = requireArguments().getString("Key")
//        val bundle = Bundle()

//        val intent = Intent(context, MainActivity::class.java)
//        bundle.putString("Key", "0")
//        intent.putExtras(bundle)
//        startActivity(intent)


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
