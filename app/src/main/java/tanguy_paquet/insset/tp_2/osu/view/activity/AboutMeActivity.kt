package tanguy_paquet.insset.tp_2.osu.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tanguy_paquet.insset.tp_2.databinding.ActivityAboutMeBinding

class AboutMeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}