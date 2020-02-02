package br.com.mrocigno.renomeadordefoto.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mrocigno.domain.Constants
import br.com.mrocigno.infrastructure.utils.PermissionsUtils
import br.com.mrocigno.renomeadordefoto.services.ReadGuides
import br.com.mrocigno.renomeadordefoto.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        proceed()
    }

    private fun proceed() {
        if (!PermissionsUtils.hasStoragePermission(this)) {
            PermissionsUtils.requestStoragePermission(this)
        } else {
            val externalStorage = System.getenv("EXTERNAL_STORAGE")
            PermissionsUtils.mkdir(Constants.csvFolder)
            PermissionsUtils.mkdir(Constants.photosFolder)

            startService(Intent(this, ReadGuides::class.java))
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        proceed()
    }

}