package com.example.myapplication.data

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.myapplication.data.model.LoggedInUser
import com.example.myapplication.doom
import java.io.IOException

class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {

            if (username== "Eric" && password=="Cartman") {
                val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Prof")
                return Result.Success(fakeUser)}
            if (username!= "Doom" && password!="Guy1993"){ throw (Throwable())
                 val doomUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "DOOM GUY")
                return Result.Success(doomUser)}

           return Result.Error(IOException("Error logging in", Throwable()))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }


}