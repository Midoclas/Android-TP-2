package tanguy_paquet.insset.tp_2.osu.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import tanguy_paquet.insset.tp_2.databinding.ActivityHomePageBinding
import tanguy_paquet.insset.tp_2.firebase.view.FirebaseLoginActivity
import tanguy_paquet.insset.tp_2.firebase.viewmodel.FirebaseAuthViewModel
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    private lateinit var mViewModel: FirebaseAuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[FirebaseAuthViewModel::class.java]

        binding.startOsuActivityButton.setOnClickListener {
            goToOsuActivityIntent()
        }

        binding.aboutMe.setOnClickListener {
            goToAboutMeActivity()
        }

        binding.textUID.text = intent.getStringExtra("UID")

        binding.firebaseButtonDisconnect.setOnClickListener { disconnect() }
    }

    private fun goToOsuActivityIntent() {
        val nav = Intent(this, OsuMainActivity::class.java)
        if (binding.usernameInput.text.toString() != "") {
            nav.putExtra("username", binding.usernameInput.text.toString())
        } else {
            nav.putExtra("username", Random.nextInt(4500000, 4600000).toString())
        }


        startActivity(nav)
    }

    private fun goToAboutMeActivity() {
        startActivity(Intent(this, AboutMeActivity::class.java))
    }

    private fun disconnect() {
        mViewModel.disconnectUser()
        startActivity(Intent(this, FirebaseLoginActivity::class.java))
    }
}

