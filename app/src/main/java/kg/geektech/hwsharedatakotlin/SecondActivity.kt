package kg.geektech.hwsharedatakotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val data: String? = intent.getStringExtra(MainActivity.KEY_RES).toString()
        data?.let { ed_get_heading.setText(data) }

        btn_back.setOnClickListener {
            if (!ed_get_heading.text.isNullOrBlank()) {
                setResult(
                    Activity.RESULT_OK,
                    Intent().putExtra(MainActivity.KEY_RES, ed_get_heading.text?.toString())
                )
                finish()

            } else {
                Toast.makeText(this, "Заполните поля!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
