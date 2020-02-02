package br.com.mrocigno.infrastructure.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import br.com.mrocigno.infrastructure.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_abstract.*

abstract class AbstractActivity<B : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutId : Int
    abstract val abstractViewModel : AbstractViewModel
    abstract fun initVars(binder : B)
    abstract fun initActions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abstract)
        val binding = addContentView()
        binding.lifecycleOwner = this
        initVars(binding)

        setSupportActionBar(toolbar)

        lifecycle.addObserver(abstractViewModel)
        initActions()
        configureFab(fabAbstract)
    }

    private fun addContentView() : B{
        val inflater = LayoutInflater.from(this)
        val binder = DataBindingUtil.inflate<B>(inflater, layoutId, null, false)
        container.addView(binder.root)
        return binder
    }

    open fun configureFab(fab: FloatingActionButton){
        fab.hide()
    }


}