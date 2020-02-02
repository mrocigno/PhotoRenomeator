package br.com.mrocigno.renomeadordefoto.ui.guide

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mrocigno.infrastructure.base.AbstractActivity
import br.com.mrocigno.infrastructure.base.AbstractViewModel
import br.com.mrocigno.infrastructure.utils.bind
import br.com.mrocigno.renomeadordefoto.R
import br.com.mrocigno.renomeadordefoto.databinding.ActivityGuideBinding
import br.com.mrocigno.renomeadordefoto.ui.guide.adapter.GuideAdapter
import br.com.mrocigno.renomeadordefoto.ui.service.ServiceActivity
import kotlinx.android.synthetic.main.activity_guide.*
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class GuideActivity : AbstractActivity<ActivityGuideBinding>() {

    private var guideName = ""

    override val layoutId: Int get() = R.layout.activity_guide

    private val guideViewModel : GuideViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel get() = guideViewModel

    override fun initVars(binder: ActivityGuideBinding) {}

    override fun initActions() {
        intent.getStringExtra(GUIDE_NAME)?.run {
            guideName = this
        }
        bind(guideViewModel.list) {
            rcyServices.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rcyServices.adapter = GuideAdapter(this, it){ guide ->
                val intent = Intent(this, ServiceActivity::class.java)
                intent.putExtra(ServiceActivity.GUIDE_EXTRA, guide)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        guideViewModel.getServices(guideName)
    }

    companion object {
        const val GUIDE_NAME = "GuideName"
    }
}