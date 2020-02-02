package br.com.mrocigno.infrastructure.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import java.io.File

class PermissionsUtils {

    companion object {
        fun mkdir(local: String) {
            val dir = File(local)
            if (!dir.exists()) {
                dir.mkdirs()
            }
        }

        fun hasStoragePermission(context: Context): Boolean {
            return ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }

        fun requestStoragePermission(activity: Activity) {
            val permission =
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

            ActivityCompat.requestPermissions(
                activity,
                permission,
                0
            )
        }
    }

}