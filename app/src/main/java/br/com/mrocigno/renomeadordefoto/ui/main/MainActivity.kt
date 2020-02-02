package br.com.mrocigno.renomeadordefoto.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.ColorFilter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.infrastructure.base.AbstractActivity
import br.com.mrocigno.infrastructure.base.AbstractViewModel
import br.com.mrocigno.infrastructure.utils.bind
import br.com.mrocigno.renomeadordefoto.R
import br.com.mrocigno.renomeadordefoto.databinding.ActivityMainBinding
import br.com.mrocigno.renomeadordefoto.services.ReadGuides
import br.com.mrocigno.renomeadordefoto.ui.guide.GuideActivity
import br.com.mrocigno.renomeadordefoto.ui.main.adapter.MainAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AbstractActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initVars(binder: ActivityMainBinding) {
        binder.swpMain.setOnRefreshListener {
            mainViewModel.listGuides()
        }
    }

    override fun initActions() {
        bind(mainViewModel.list, ::setMainAdapter)
        bind(mainViewModel.loading) {
            swpMain.isRefreshing = it
        }
    }

    private fun setMainAdapter(list: List<GuideList>){
        rcyGuides.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcyGuides.adapter = MainAdapter(this, list) {
            val intent = Intent(this@MainActivity, GuideActivity::class.java)
            intent.putExtra(GuideActivity.GUIDE_NAME, it.guide)
            startActivity(intent)
        }
    }

    private val mainViewModel : MainViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel
        get() = mainViewModel

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            mainViewModel.listGuides()
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(receiver, IntentFilter(ReadGuides.READ_GUIDES_FILTER))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

}
