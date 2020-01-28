package br.com.mrocigno.infrastructure.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class AbstractActivity<B : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutId : Int
    abstract fun initVars(binder : B)
    abstract val abstractViewModel : AbstractViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<B>(this, layoutId)
        binding.lifecycleOwner = this
        initVars(binding)

        lifecycle.addObserver(abstractViewModel)
    }

}