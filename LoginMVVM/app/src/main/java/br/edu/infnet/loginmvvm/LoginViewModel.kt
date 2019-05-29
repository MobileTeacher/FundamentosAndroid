package br.edu.infnet.loginmvvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

class LoginViewModel: ViewModel() {

    var isCheckingLogin = MutableLiveData<Boolean>().apply { value = false }
    var userName = MutableLiveData<String?>()
    var warningMessage = MutableLiveData<String>()

    fun loginWithEmailAndPassword(email: String, password: String){
        isCheckingLogin.value = true
        //TimeUnit.SECONDS.sleep(2);
        if (password == users[email]){
            //sucesso
            userName.value = null
            warningMessage.value = "Usuário Logado"
        } else {
            // falhou
            warningMessage.value = "login ou senha inválidos"
            userName.value = names[email]
        }
        isCheckingLogin.value = false
    }

}