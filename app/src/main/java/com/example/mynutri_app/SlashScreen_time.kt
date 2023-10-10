import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.core.widget.ImageViewCompat

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crie um ImageView programaticamente
        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.your_logo)
        imageView.setBackgroundColor(ContextCompat.getColor(this, R.color.terciary_color))

        val delayMillis: Long = 2000


        val handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, delayMillis)
    }
}
