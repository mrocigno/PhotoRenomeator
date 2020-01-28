package br.com.mrocigno.renomeadordefoto.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import br.com.mrocigno.data.db.dao.GuidesDao
import br.com.mrocigno.domain.Constants
import br.com.mrocigno.domain.entity.Guide
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths


class ReadGuides : Service(){

    private val dao : GuidesDao by inject()

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        GlobalScope.launch {
            readData()
            dao.add(Guide(null,"Teste"))
            Log.d("DEBUG TEST", "${dao.listAll()}")
        }
        return START_NOT_STICKY

    }

    private fun readData() {
        val csvFolder = File(Constants.csvFolder)
        if(csvFolder.exists() && csvFolder.isDirectory){
            csvFolder.listFiles()?.forEach {
                val reader = BufferedReader(InputStreamReader(it.inputStream(), Charset.forName("UTF-8")))
                var line = reader.readLine()
                while(line != null){
                    Log.d("DEBUG TEST", line)
                    line = reader.readLine()
                }
            }
        }
    }

}