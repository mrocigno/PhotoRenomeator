package br.com.mrocigno.infrastructure.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.exifinterface.media.ExifInterface
import java.io.File
import java.io.FileOutputStream

class PicturesUtils {

    companion object {

        fun getFileAsBitmap(path : String) : Bitmap? {
            return BitmapFactory.decodeFile(path)
        }

        fun getCompressedBitmapFile(path: String, compressor: Int = 80, fixOrientation: Boolean = true): Bitmap? {
            val bitmap = if(fixOrientation) {
                getFileAsBitmap(path)?.rotateBitmap(path)
            } else {
                getFileAsBitmap(path)
            }
            bitmap?.let {
                val outStream = FileOutputStream(File(path))
                it.compress(Bitmap.CompressFormat.JPEG, compressor, outStream)
//                it.recycle()
                outStream.flush()
                outStream.close()
            }
            return bitmap
        }

    }

}