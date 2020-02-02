package br.com.mrocigno.renomeadordefoto.ui.service.binding

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.mrocigno.domain.entity.Photo
import br.com.mrocigno.infrastructure.utils.PicturesUtils
import com.bumptech.glide.Glide

class ImgBind {

    companion object {

        @BindingAdapter("bitmap")
        @JvmStatic
        fun setBitmap(imgView: ImageView, photo: Photo?){
            if(photo != null){
                val picture = if(photo.path != "") {
                    PicturesUtils.getResizedBitmapFile(photo.path, imgView.width, imgView.height)
                } else null
                imgView.setImageBitmap(picture)
            } else
                imgView.setImageBitmap(null)
        }

    }

}