package br.com.mrocigno.infrastructure.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream
import kotlin.math.min

class PicturesUtils {

    companion object {

        fun getBitmapFile(path : String) : Bitmap? {
            return BitmapFactory.decodeFile(path)
        }

        fun compressFile(path: String, compressor: Int = 80, fixOrientation: Boolean = true){
            val bitmap = if(fixOrientation) {
                getBitmapFile(path)?.rotateBitmap(path)
            } else {
                getBitmapFile(path)
            }
            bitmap?.let {
                val outStream = FileOutputStream(File(path))
                it.compress(Bitmap.CompressFormat.JPEG, compressor, outStream)
                it.recycle()
                outStream.flush()
                outStream.close()
            }
        }


        fun getResizedBitmapFile(path: String, targetWidth: Int, targetHeight: Int): Bitmap? {
            val options = BitmapFactory.Options().apply {
                inJustDecodeBounds = true
                BitmapFactory.decodeFile(path, this)
            }

            val photoW = options.outWidth
            val photoH = options.outHeight

            val reductionScale = min(photoW / targetWidth, photoH / targetHeight)

            return options.run {
                inJustDecodeBounds = false
                inSampleSize = reductionScale

                BitmapFactory.decodeFile(
                    path,
                    this
                )
            }
        }

    }

}