package br.com.mrocigno.infrastructure.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class AbstractFragment<B : ViewDataBinding> : Fragment() {

    abstract val layoutId : Int
    abstract fun initVars(view : View)
    abstract fun initAction()
    abstract fun initBinder(binder : B)
    abstract val abstractViewModel : AbstractViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutId, container, false)
        val binding = DataBindingUtil.bind<B>(view)
        binding!!.lifecycleOwner = this
        initBinder(binding)

        lifecycle.addObserver(abstractViewModel)

        initVars(view)
        initAction()
        return view
    }

}