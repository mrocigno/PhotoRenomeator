package br.com.mrocigno.renomeadordefoto.ui.service

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import androidx.core.content.FileProvider
import br.com.mrocigno.domain.Constants
import br.com.mrocigno.domain.entity.GuideName
import br.com.mrocigno.domain.entity.Photo
import br.com.mrocigno.infrastructure.base.AbstractActivity
import br.com.mrocigno.infrastructure.base.AbstractViewModel
import br.com.mrocigno.infrastructure.utils.PermissionsUtils
import br.com.mrocigno.infrastructure.utils.PicturesUtils
import br.com.mrocigno.infrastructure.utils.bind
import br.com.mrocigno.renomeadordefoto.BuildConfig
import br.com.mrocigno.renomeadordefoto.R
import br.com.mrocigno.renomeadordefoto.databinding.ActivityServiceBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_service.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class ServiceActivity : AbstractActivity<ActivityServiceBinding>() {

    private val listPhotos = ArrayList<Photo>()

    override val layoutId: Int get() = R.layout.activity_service

    private val serviceViewModel : ServiceViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel get() = serviceViewModel

    override fun initVars(binder: ActivityServiceBinding) {
        serviceViewModel.guide = intent.getSerializableExtra(GUIDE_EXTRA) as GuideName
        binder.serviceViewModel = serviceViewModel
    }

    private fun handleList(photo: Photo){
        listPhotos.remove(photo)
        if(photo.path != "") {
            listPhotos.add(photo)
        }
    }

    override fun initActions() {
        cardSelect1.setOnClickListener { callCamera(1) }
        cardSelect2.setOnClickListener { callCamera(2) }
        cardSelect3.setOnClickListener { callCamera(3) }
        cardSelect4.setOnClickListener { callCamera(4) }
        cardSelect5.setOnClickListener { callCamera(5) }

        fabDel1.setOnClickListener { remove(1) }
        fabDel2.setOnClickListener { remove(2) }
        fabDel3.setOnClickListener { remove(3) }
        fabDel4.setOnClickListener { remove(4) }
        fabDel5.setOnClickListener { remove(5) }

        bind(serviceViewModel.photo1, ::handleList)
        bind(serviceViewModel.photo2, ::handleList)
        bind(serviceViewModel.photo3, ::handleList)
        bind(serviceViewModel.photo4, ::handleList)
        bind(serviceViewModel.photo5, ::handleList)

        serviceViewModel.findPhotos()
    }

    private fun remove(id: Int){
        when(id){
            1 -> {
                listPhotos.remove(serviceViewModel.photo1.value!!)
                serviceViewModel.deletePhoto(serviceViewModel.photo1.value!!)
                serviceViewModel.photo1.value = null
            }
            2 -> {
                listPhotos.remove(serviceViewModel.photo2.value!!)
                serviceViewModel.deletePhoto(serviceViewModel.photo2.value!!)
                serviceViewModel.photo2.value = null
            }
            3 -> {
                listPhotos.remove(serviceViewModel.photo3.value!!)
                serviceViewModel.deletePhoto(serviceViewModel.photo3.value!!)
                serviceViewModel.photo3.value = null
            }
            4 -> {
                listPhotos.remove(serviceViewModel.photo4.value!!)
                serviceViewModel.deletePhoto(serviceViewModel.photo4.value!!)
                serviceViewModel.photo4.value = null
            }
            5 -> {
                listPhotos.remove(serviceViewModel.photo5.value!!)
                serviceViewModel.deletePhoto(serviceViewModel.photo5.value!!)
                serviceViewModel.photo5.value = null
            }
        }
    }

    override fun configureFab(fab: FloatingActionButton) {
        val drawable = getDrawable(R.drawable.ic_check)
        drawable?.setTint(getColor(android.R.color.white))
        fab.setImageDrawable(drawable)
        fab.setOnClickListener {
            serviceViewModel.save(listPhotos)
            finish()
        }
    }

    private fun callCamera(request: Int){
        val finalPath = "${getFolder()}/${serviceViewModel.guide!!.rc} ($request).jpg"
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
            val finalPath = "${getFolder()}/${serviceViewModel.guide!!.rc} ($requestCode).jpg"
            PicturesUtils.compressFile(finalPath)
            when(requestCode){
                1 -> serviceViewModel.photo1.value = serviceViewModel.photo1.value?.apply { path = finalPath } ?: Photo(serviceId = serviceViewModel.guide!!.fc, path = finalPath)
                2 -> serviceViewModel.photo2.value = serviceViewModel.photo2.value?.apply { path = finalPath } ?: Photo(serviceId = serviceViewModel.guide!!.fc, path = finalPath)
                3 -> serviceViewModel.photo3.value = serviceViewModel.photo3.value?.apply { path = finalPath } ?: Photo(serviceId = serviceViewModel.guide!!.fc, path = finalPath)
                4 -> serviceViewModel.photo4.value = serviceViewModel.photo4.value?.apply { path = finalPath } ?: Photo(serviceId = serviceViewModel.guide!!.fc, path = finalPath)
                5 -> serviceViewModel.photo5.value = serviceViewModel.photo5.value?.apply { path = finalPath } ?: Photo(serviceId = serviceViewModel.guide!!.fc, path = finalPath)
            }
        }
    }

    private fun getFolder(): String {
        val guideName = serviceViewModel.guide!!.guide.replace("/", "-")
        val path = "${Constants.photosFolder}/$guideName"
        PermissionsUtils.mkdir(path)
        return path
    }

    companion object {

        const val GUIDE_EXTRA = "GuideExtra"

    }
}