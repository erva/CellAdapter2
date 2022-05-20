package io.erva.celladapter2.cell

import io.erva.celladapter2.Cell
import io.erva.celladapter2.Cell.Listener
import io.erva.celladapter2.databinding.ItemBetaBinding
import io.erva.celladapter2.model.BetaModel

class BetaCell(private val binding: ItemBetaBinding) :
    Cell<BetaModel, ItemBetaBinding, Listener<BetaModel>>(binding) {

    override fun bindView() {
        val item = item()
        binding.tvBeta.text = item.beta
    }
}
