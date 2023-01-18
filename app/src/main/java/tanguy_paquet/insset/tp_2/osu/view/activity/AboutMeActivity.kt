package tanguy_paquet.insset.tp_2.osu.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tanguy_paquet.insset.tp_2.databinding.AboutMeBinding
import tanguy_paquet.insset.tp_2.databinding.HomePageBinding

class AboutMeActivity: AppCompatActivity() {
    private lateinit var binding: AboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}