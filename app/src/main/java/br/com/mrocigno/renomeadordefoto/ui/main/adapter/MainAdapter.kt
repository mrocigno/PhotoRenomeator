package br.com.mrocigno.renomeadordefoto.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.mrocigno.domain.entity.GuideList
import br.com.mrocigno.renomeadordefoto.R
import br.com.mrocigno.renomeadordefoto.databinding.CardGuideBinding

class MainAdapter(
    private val context: Context,
    private val list: List<GuideList>,
    private val onItemSelect: (item: GuideList) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binder = DataBindingUtil.inflate<CardGuideBinding>(inflater, R.layout.card_guide, parent, false)
        return ViewHolder(binder, onItemSelect)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(
        private val binder : CardGuideBinding,
        private val onItemSelect: (item: GuideList) -> Unit
    ) : RecyclerView.ViewHolder(binder.root) {

        fun bind(data : GuideList){
            binder.model = data
            binder.lnlCardSelector.setOnClickListener {
                onItemSelect(data)
            }
        }

    }
}