package br.com.mrocigno.renomeadordefoto.ui.guide.adapter

import android.content.Context
import br.com.mrocigno.domain.entity.Guide
import br.com.mrocigno.infrastructure.base.AbstractAdapter
import br.com.mrocigno.renomeadordefoto.R
import br.com.mrocigno.renomeadordefoto.databinding.CardServiceBinding

class GuideAdapter(
    context: Context,
    list: List<Guide>,
    val onItemSelect: (data: Guide) -> Unit
) : AbstractAdapter<CardServiceBinding, Guide>(
    context,
    list,
    R.layout.card_service
) {
    override fun onBind(data: Guide, binder: CardServiceBinding) {
        binder.model = data
        binder.ctlCardSelector.setOnClickListener {
            onItemSelect(data)
        }
    }
}