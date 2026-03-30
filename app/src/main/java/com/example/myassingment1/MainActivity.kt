package com.example.myassingment1
import android.os.Bundle
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtSpark = findViewById<EditText>(R.id.edtSpark)
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnSuggestions = findViewById<Button>(R.id.btnSuggestions)

        btnSuggestions.setOnClickListener()
        {
            //Log is used to manually check that the code runs perfectly
            Log.d(TAG,"confirm that the Suggestions button is pressed.")

            val sparks = edtSpark.text.toString().trim()
            val result: String = if(sparks.equals("Morning",ignoreCase = true))
            {
                "Send a Good Morning text to a family member."
            }
            else if(sparks.equals("Mid-Morning",ignoreCase = true))
            {
                "Reach out to a colleague with a quick Thank You."
            }
            else if(sparks.equals("Afternoon",ignoreCase = true))
            {
                "Share a funny meme or interesting link with a friend."
            }
            else if(sparks.equals("Afternoon Snack Time",ignoreCase = true))
            {
                "Share a funny meme or interesting link with a friend."
            }
            else if(sparks.equals("Dinner",ignoreCase = true))
            {
                "Call a friend or a relative for a 5-minute catch-up."
            }
            else if(sparks.equals("Night",ignoreCase = true))
            {
                "Leave a thoughtful comment on a friend's post."
            }
            else
            {
                "Please find a valid spark"
            }
            //txtDisplay will display the messages.
            txtDisplay.text = result

            Log.i(TAG,"Confirm that the correct message is sent.")
        }
        // Reset button ensures that all fields have been cleared
        btnReset.setOnClickListener()
        {
            Log.d(TAG,"Confirm that the reset button is pressed.")

            edtSpark.text.clear()
            txtDisplay.text = "Suggestions will appear here."

            Log.i(TAG,"Confirm that all fields have been cleared.")
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtDisplay)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}