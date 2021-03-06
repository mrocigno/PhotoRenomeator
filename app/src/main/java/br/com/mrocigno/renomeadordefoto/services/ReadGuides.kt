package br.com.mrocigno.renomeadordefoto.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import br.com.mrocigno.data.data.GuideData
import br.com.mrocigno.data.db.dao.GuidesDao
import br.com.mrocigno.domain.Constants
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.charset.Charset


class ReadGuides : Service(){

    private val dao : GuidesDao by inject()

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        GlobalScope.launch {
            readData()
            applicationContext.sendBroadcast(Intent(READ_GUIDES_FILTER))
        }
        return START_NOT_STICKY

    }

    private suspend fun readData() {
        val csvFolder = File(Constants.csvFolder)
        if(csvFolder.exists() && csvFolder.isDirectory){
            csvFolder.listFiles()?.forEach {
                val reader = BufferedReader(InputStreamReader(it.inputStream(), Charset.forName("UTF-8")))
                reader.readLine() // Jump first line

                val guide = arrayListOf<GuideData>()
                var line = reader.readLine()
                while(line != null){
                    guide.add(GuideData.parseCsv(line))
                    line = reader.readLine()
                }

                dao.insertMany(guide)
            }
        }
    }

    companion object {
        const val READ_GUIDES_FILTER = "ReadGuidesAction"
    }

}