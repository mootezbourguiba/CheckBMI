package tm.esprit.checkbmi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import tm.esprit.checkbmi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight: EditText = findViewById(R.id.etWeight)
        val etHeight: EditText = findViewById(R.id.etHeight)
        val btnCalculateBMI: Button = findViewById(R.id.btnCalculateBMI)
        val tvBMI: TextView = findViewById(R.id.tvBMI)
        val tvInterpretation: TextView = findViewById(R.id.tvInterpretation)

        btnCalculateBMI.setOnClickListener {
            val weightStr = etWeight.text.toString()
            val heightStr = etHeight.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toDouble()
                val height = heightStr.toDouble()
                val bmi = weight / (height * height)

                tvBMI.text = String.format("Your BMI: %.2f", bmi)
                when {
                    bmi < 18.5 -> tvInterpretation.text = "Underweight"
                    bmi < 24.9 -> tvInterpretation.text = "Normal weight"
                    bmi < 29.9 -> tvInterpretation.text = "Overweight"
                    else -> tvInterpretation.text = "Obesity"
                }
            } else {
                tvBMI.text = "Please fill in both fields."
                tvInterpretation.text = ""
            }
        }
    }
}
