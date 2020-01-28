package br.com.mrocigno.renomeadordefoto.ui.main

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.FileProvider
import br.com.mrocigno.infrastructure.base.AbstractActivity
import br.com.mrocigno.infrastructure.base.AbstractViewModel
import br.com.mrocigno.infrastructure.utils.PermissionsUtils
import br.com.mrocigno.infrastructure.utils.PicturesUtils.Companion.getCompressedBitmapFile
import br.com.mrocigno.renomeadordefoto.BuildConfig
import br.com.mrocigno.renomeadordefoto.R
import br.com.mrocigno.renomeadordefoto.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File


class MainActivity : AbstractActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initVars(binder: ActivityMainBinding) {
        binder.teste.setOnClickListener {
            if(!PermissionsUtils.hasStoragePermission(this)){
                PermissionsUtils.requestStoragePermission(this)
            } else {
                val extStorage = System.getenv("EXTERNAL_STORAGE")
                val path = "$extStorage/Siscon"
                val finalPath = "$path/heheboy.jpg"
                PermissionsUtils.criarDiretorio(path)

                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                intent.putExtra(
                    MediaStore.EXTRA_OUTPUT,
                    FileProvider.getUriForFile(
                        this,
                        "${BuildConfig.APPLICATION_ID}.provider",
                        File(finalPath)
                    )
                )

                startActivityForResult(intent, 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            Log.d("asdas", "result ok")

            val extStorage = System.getenv("EXTERNAL_STORAGE")
            val path = "$extStorage/Siscon"
            val finalPath = "$path/heheboy.jpg"

            var picture = getCompressedBitmapFile(finalPath)

        }
    }

    private val mainViewModel : MainViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel
        get() = mainViewModel


}
