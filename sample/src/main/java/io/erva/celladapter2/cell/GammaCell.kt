package io.erva.celladapter2.cell

import io.erva.celladapter2.Cell
import io.erva.celladapter2.Cell.Listener
import io.erva.celladapter2.databinding.ItemGammaBinding
import io.erva.celladapter2.model.GammaModel

class GammaCell(private val binding: ItemGammaBinding) :
    Cell<GammaModel, ItemGammaBinding, Listener<GammaModel>>(binding) {

    override fun bindView() {
        val item = item()
        binding.tvGamma.text = item.gamma
    }
}
