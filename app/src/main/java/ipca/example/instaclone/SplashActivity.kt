package ipca.example.instaclone

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ipca.example.instaclone.databinding.ActivitySplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        auth = Firebase.auth

        // auth.signOut() sair da conta


        lifecycleScope.launch (Dispatchers.IO){
            delay(2000)
            lifecycleScope.launch (Dispatchers.Main) {
                val currentUser = auth.currentUser
                if (currentUser != null){
                    startActivity(
                        Intent(this@SplashActivity,
                            MainActivity::class.java)
                    )
                }else{
                    startActivity(
                        Intent(this@SplashActivity,
                            LoginActivity::class.java)
                    )
                }
                finish()
            }
        }

    }
}