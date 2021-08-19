package kg.geektech.hwsharedatakotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var startForResult: ActivityResultLauncher<Intent>

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    ed_heading.setText(intent?.getStringExtra(KEY_RES))
                }
            }

        btn_next.setOnClickListener {
            if (!ed_heading.text.isNullOrBlank()) {
                startForResult.launch(
                    Intent(this, SecondActivity::class.java)
                        .putExtra(KEY_RES, ed_heading.text?.toString())
                )
            } else {
                Toast.makeText(this, "Поля пустые!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val KEY_RES = "res"
    }
}