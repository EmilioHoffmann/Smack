package com.example.emili.smack.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.emili.smack.R
import com.example.emili.smack.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profiledefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View) {
        val random = Random()
        val color = random.nextInt(2)
        val avatarNumber = random.nextInt(28)

        if (color == 0) {
            userAvatar = "light$avatarNumber"
        } else {
            userAvatar = "dark$avatarNumber"
        }

        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)
    }

    fun generateColorClicked(view: View) {
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble()/255
        val savedG = g.toDouble()/255
        val savedB = b.toDouble()/255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"
    }

    fun createUserClicked(view: View) {
        val userEmail = createEmailText.text.toString()
        val userPassword = createPasswordText.text.toString()

        AuthService.registerUser(this, userEmail, userPassword){registerSucess ->
            if (registerSucess){
                AuthService.loginUser(this, userEmail, userPassword){loginSucess ->
                    if(loginSucess){
                        println(AuthService.authToken)
                        println(AuthService.userEmail)
                    }
                }
            }
        }
    }


}
