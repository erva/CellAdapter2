package io.erva.celladapter2.base.cell

import io.erva.celladapter2.Cell
import io.erva.celladapter2.base.model.BetaModel
import io.erva.celladapter2.databinding.ItemBaseBetaBinding

class BetaCell(private val binding: ItemBaseBetaBinding) :
    Cell<BetaModel, ItemBaseBetaBinding, BetaCell.Listener>(binding) {

    override fun bindView() {
        binding.textView.text = item().text
    }

    interface Listener : Cell.Listener<BetaModel>
}
