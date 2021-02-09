package `in`.pratikchakraborty.otpverification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        auth= FirebaseAuth.getInstance()
        var currentUser=auth.currentUser

        //Reference
        val logout = findViewById<Button>(R.id.idLogout)

        if(currentUser==null){
            startActivity(Intent(this,Login::class.java))
            finish()
        }

        logout.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,Login::class.java))
            finish()
        }

    }
}