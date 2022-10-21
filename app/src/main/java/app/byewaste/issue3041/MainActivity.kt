package app.byewaste.issue3041

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listItems = listOf(
            "Rotterdam",
            "Amsterdam",
            "Den haag",
            "Utrecht",
        )


        val cityInputField = findViewById<TextInputLayout>(R.id.cityInputField)
        val dropDown = cityInputField.editText as AutoCompleteTextView
        dropDown.setAdapter(
            object : ArrayAdapter<String>(this, 0, listItems) {


                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    val textView = (convertView ?: TextView(context)) as TextView
                    return textView.apply {
                        text = getItem(position)
                    }
                }


                override fun getFilter() = object : Filter() {
                    override fun performFiltering(constraint: CharSequence?) = null
                    override fun publishResults(constraint: CharSequence?, results: FilterResults?) = Unit
                }
            }
        )
    }
}