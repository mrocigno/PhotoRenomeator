package br.com.mrocigno.infrastructure.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractAdapter<B: ViewDataBinding, LT>(
    private val context: Context,
    private val list: List<LT>,
    private val layoutId : Int
) : RecyclerView.Adapter<AbstractAdapter.ViewHolder<B>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {
        val inflater = LayoutInflater.from(context)
        val binder = DataBindingUtil.inflate<B>(inflater, layoutId, parent, false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
        onBind(list[position], holder.binder)
    }

    abstract fun onBind(data: LT, binder: B)

    class ViewHolder<B: ViewDataBinding>(val binder : B) : RecyclerView.ViewHolder(binder.root)
}