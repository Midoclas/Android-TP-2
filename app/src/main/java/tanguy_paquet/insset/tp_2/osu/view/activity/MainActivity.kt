package tanguy_paquet.insset.tp_2.osu.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tanguy_paquet.insset.tp_2.databinding.HomePageBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: HomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startOsuActivityButton.setOnClickListener {
            goToOsuActivityIntent()
        }
    }

    private fun goToOsuActivityIntent() {
        val nav = Intent(this, OsuMainActivity::class.java)
        nav.putExtra("username", binding.usernameInput.text.toString())
        startActivity(nav)
    }
}

