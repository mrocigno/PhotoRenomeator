package br.com.mrocigno.renomeadordefoto.ui.service

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.provider.MediaStore
import androidx.core.content.FileProvider
import br.com.mrocigno.domain.Constants
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.infrastructure.base.AbstractActivity
import br.com.mrocigno.infrastructure.base.AbstractViewModel
import br.com.mrocigno.infrastructure.utils.PermissionsUtils
import br.com.mrocigno.infrastructure.utils.PicturesUtils
import br.com.mrocigno.renomeadordefoto.BuildConfig
import br.com.mrocigno.renomeadordefoto.R
import br.com.mrocigno.renomeadordefoto.databinding.ActivityServiceBinding
import kotlinx.android.synthetic.main.activity_service.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class ServiceActivity : AbstractActivity<ActivityServiceBinding>() {

    private lateinit var guide : Guide

    override val layoutId: Int get() = R.layout.activity_service

    private val serviceViewModel : ServiceViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel get() = serviceViewModel

    override fun initVars(binder: ActivityServiceBinding) {
        guide = intent.getSerializableExtra(GUIDE_EXTRA) as Guide
        binder.serviceViewModel = serviceViewModel
    }

    override fun initActions() {
        cardSelect1.setOnClickListener { callCamera(1) }
        cardSelect2.setOnClickListener { callCamera(2) }
        cardSelect3.setOnClickListener { callCamera(3) }
        cardSelect4.setOnClickListener { callCamera(4) }
        cardSelect5.setOnClickListener { callCamera(5) }
    }

    private fun callCamera(request: Int){
        val finalPath = "${Constants.photosFolder}/${guide.rc} ($request).jpg"
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(
            MediaStore.EXTRA_OUTPUT,
            FileProvider.getUriForFile(
                this,
                "${BuildConfig.APPLICATION_ID}.provider",
                File(finalPath)
            )
        )

        startActivityForResult(intent, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            val finalPath = "${Constants.photosFolder}/${guide.rc} ($requestCode).jpg"
            val picture = PicturesUtils.getCompressedBitmapFile(finalPath)
            when(requestCode){
                1 -> serviceViewModel.photo1.value = picture
                2 -> serviceViewModel.photo2.value = picture
                3 -> serviceViewModel.photo3.value = picture
                4 -> serviceViewModel.photo4.value = picture
                5 -> serviceViewModel.photo5.value = picture
            }
        }
    }

    companion object {

        const val GUIDE_EXTRA = "GuideExtra"

    }
}