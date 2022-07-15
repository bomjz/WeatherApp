package tech.edem.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import tech.edem.weatherapp.databinding.ActivityMainBinding

const val API_KEY = "34b77c533c454fe386c160221221507"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bGet.setOnClickListener { }

        getResult("London")

    }

    private fun getResult(name: String) {
        val url = "https://api.weatherapi.com/v1/current.json?key=$API_KEY&q=$name&aqi=no"


        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            { response ->
                Log.d("MyLog", "Response: $response")

            },
            {
                Log.d("MyLog", "Volley error: $it")

            }
        )

        queue.add(stringRequest)
    }
}