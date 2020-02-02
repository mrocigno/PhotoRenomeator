package br.com.mrocigno.renomeadordefoto.ui.service.binding

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImgBind {

    companion object {

        @BindingAdapter("bitmap")
        @JvmStatic
        fun setBitmap(imgView: ImageView, bitmap: Bitmap?){

//            imgView.setImageBitmap(bitmap)
        }

    }

}