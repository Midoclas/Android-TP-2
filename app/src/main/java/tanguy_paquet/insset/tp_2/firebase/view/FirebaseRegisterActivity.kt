package tanguy_paquet.insset.tp_2.firebase.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.databinding.ActivityFirebaseLoginBinding
import tanguy_paquet.insset.tp_2.databinding.ActivityFirebaseRegisterBinding
import tanguy_paquet.insset.tp_2.firebase.viewmodel.FirebaseAuthViewModel

class FirebaseRegisterActivity: AppCompatActivity() {
    private lateinit var mViewModel: FirebaseAuthViewModel
    private lateinit var binding: ActivityFirebaseRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_login)

        binding = ActivityFirebaseRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mViewModel = ViewModelProvider(this)[FirebaseAuthViewModel::class.java]
        binding.firebaseButtonRegister.setOnClickListener { register() }
        binding.firebaseButtonLogin.setOnClickListener { goToLoginActivity() }

    }

    private fun checkConformityFields(): Boolean {
        var isValid = true

        if (TextUtils.isEmpty(binding.firebaseUserEmail.text.toString()) || TextUtils.isEmpty(binding.firebaseUserPassword.text.toString())) {
            isValid = false
        }
        return isValid
    }

    private fun register() {
        if (checkConformityFields()) {
            mViewModel.registerNewUser(binding.firebaseUserEmail.text.toString(), binding.firebaseUserPassword.text.toString())
            goToLoginActivity()
        }
    }

    private fun goToLoginActivity() {
        startActivity(Intent(this, FirebaseLoginActivity::class.java))
    }
}