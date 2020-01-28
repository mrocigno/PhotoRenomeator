package br.com.mrocigno.infrastructure.utils

import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.exifinterface.media.ExifInterface
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any> LifecycleOwner.bind(data: LiveData<T>, function: (id: T) -> Unit) {
    data.observe(this, Observer {
        it?.also {source ->
            function(source)
        }
    })
}

fun Bitmap.rotateBitmap(path : String): Bitmap? {
    val exif = ExifInterface(path)

    val orientation = exif.getAttributeInt(
        ExifInterface.TAG_ORIENTATION,
        ExifInterface.ORIENTATION_UNDEFINED
    )

    val matrix = Matrix()
    when (orientation) {
        ExifInterface.ORIENTATION_NORMAL -> return this
        ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.setScale((-1).toFloat(), 1F)
        ExifInterface.ORIENTATION_ROTATE_180 -> matrix.setRotate(180F)
        ExifInterface.ORIENTATION_FLIP_VERTICAL -> {
            matrix.setRotate(180F)
            matrix.postScale((-1).toFloat(), 1F)
        }
        ExifInterface.ORIENTATION_TRANSPOSE -> {
            matrix.setRotate(90F)
            matrix.postScale((-1).toFloat(), 1F)
        }
        ExifInterface.ORIENTATION_ROTATE_90 -> matrix.setRotate(90F)
        ExifInterface.ORIENTATION_TRANSVERSE -> {
            matrix.setRotate((-90).toFloat())
            matrix.postScale((-1).toFloat(), 1F)
        }
        ExifInterface.ORIENTATION_ROTATE_270 -> matrix.setRotate((-90).toFloat())
        else -> return this
    }
    return try {
        val bmRotated = Bitmap.createBitmap(
            this,
            0,
            0,
            width,
            height,
            matrix,
            true
        )
        recycle()
        bmRotated
    } catch (e: OutOfMemoryError) {
        e.printStackTrace()
        null
    }
}