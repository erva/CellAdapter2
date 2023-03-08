package io.erva.celladapter2.base.cell

import io.erva.celladapter2.Cell
import io.erva.celladapter2.base.model.AlphaModel
import io.erva.celladapter2.databinding.ItemBaseAlphaBinding

class AlphaCell(private val binding: ItemBaseAlphaBinding) :
    Cell<AlphaModel, ItemBaseAlphaBinding, AlphaCell.Listener>(binding) {

    override fun bindView() {
        binding.textView.text = item().text
        binding.buttonOne.setOnClickListener { listener()?.onPressOne(item()) }
        binding.buttonTwo.setOnClickListener { listener()?.onPressTwo(item()) }
    }

    interface Listener : Cell.Listener<AlphaModel> {

        fun onPressOne(item: AlphaModel)

        fun onPressTwo(item: AlphaModel)
    }
}
