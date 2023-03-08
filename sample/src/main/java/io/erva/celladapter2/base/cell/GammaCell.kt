package io.erva.celladapter2.base.cell

import io.erva.celladapter2.Cell
import io.erva.celladapter2.base.model.GammaModel
import io.erva.celladapter2.databinding.ItemBaseGammaBinding

class GammaCell(private val binding: ItemBaseGammaBinding) :
    Cell<GammaModel, ItemBaseGammaBinding, Cell.Listener<GammaModel>>(binding) {

    override fun bindView() {
        binding.textView.text = item().text
    }
}
