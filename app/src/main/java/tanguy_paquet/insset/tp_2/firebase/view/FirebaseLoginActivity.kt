package tanguy_paquet.insset.tp_2.firebase.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseUser
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.databinding.ActivityFirebaseLoginBinding
import tanguy_paquet.insset.tp_2.firebase.viewmodel.FirebaseAuthViewModel
import tanguy_paquet.insset.tp_2.osu.view.activity.AboutMeActivity
import tanguy_paquet.insset.tp_2.osu.view.activity.MainActivity
import tanguy_paquet.insset.tp_2.osu.view.activity.OsuMainActivity

class FirebaseLoginActivity: AppCompatActivity() {
    private lateinit var mViewModel: FirebaseAuthViewModel
    private lateinit var binding: ActivityFirebaseLoginBinding

    private var mObserverUser = Observer<FirebaseUser> {
        goToMainActivity(it)
    }

    private var mObserverError = Observer<Int> {
        updateError(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_login)

        binding = ActivityFirebaseLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mViewModel = ViewModelProvider(this)[FirebaseAuthViewModel::class.java]
        binding.firebaseButtonRegister.setOnClickListener { goToRegisterActivity() }
        binding.firebaseButtonLogin.setOnClickListener { login() }

    }

    override fun onStart() {
        super.onStart()
        mViewModel.mCurrentUser.observe(this, mObserverUser)
        mViewModel.mErrorProcess.observe(this, mObserverError)
    }

    override fun onStop() {
        mViewModel.mCurrentUser.removeObserver(mObserverUser)
        mViewModel.mErrorProcess.removeObserver(mObserverError)
        super.onStop()
    }

    private fun checkConformityFields(): Boolean {
        var isValid = true


        if (TextUtils.isEmpty(binding.firebaseUserEmail.toString()) || TextUtils.isEmpty(binding.firebaseUserPassword.toString())) {
            isValid = false
        }
        binding.firebaseError.text = "empty field"
        return isValid
    }

    private fun login() {
        if (checkConformityFields()) {
            mViewModel.loginUser(binding.firebaseUserEmail.text.toString(), binding.firebaseUserPassword.text.toString())
        }
    }

    private fun goToRegisterActivity() {
        startActivity(Intent(this, FirebaseRegisterActivity::class.java))
    }




    private fun goToMainActivity(user: FirebaseUser) {
        val nav = Intent(this, MainActivity::class.java)
        nav.putExtra("UID", "${user.uid}-${user.email}")
        startActivity(nav)
    }

    @SuppressLint("SetTextI18n")
    private fun updateError(code : Int) {
        when(code) {
            5 -> {
                binding.firebaseError.text = "disconnected"
            }
            10 -> binding.firebaseError.text = "Error when creating"
            11 -> binding.firebaseError.text = "Error when login"
        }
    }

}