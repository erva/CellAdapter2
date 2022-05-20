package io.erva.celladapter2.cell

import io.erva.celladapter2.Cell
import io.erva.celladapter2.cell.AlphaCell.CustomAlphaListener
import io.erva.celladapter2.databinding.ItemAlphaBinding
import io.erva.celladapter2.model.AlphaModel

class AlphaCell(private val binding: ItemAlphaBinding) :
    Cell<AlphaModel, ItemAlphaBinding, CustomAlphaListener>(binding) {

    override fun bindView() {
        val item = item()
        binding.tvAlpha.text = item.alpha
        binding.btnOnePress.setOnClickListener { listener()?.onPressOne(item()) }
        binding.btnTwoPress.setOnClickListener { listener()?.onPressTwo(item()) }
    }

    interface CustomAlphaListener : Listener<AlphaModel> {

        fun onPressOne(item: AlphaModel)

        fun onPressTwo(item: AlphaModel)
    }
}
