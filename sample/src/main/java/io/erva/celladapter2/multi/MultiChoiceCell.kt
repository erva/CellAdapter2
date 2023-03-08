package io.erva.celladapter2.multi

import io.erva.celladapter2.Cell
import io.erva.celladapter2.databinding.ItemMultiBinding
import io.erva.celladapter2.select.SelectableCell

class MultiChoiceCell(private val binding: ItemMultiBinding) :
    SelectableCell<MultiChoiceModel, ItemMultiBinding, Cell.Listener<MultiChoiceModel>>(binding) {

    override fun bindView() {
        binding.radioButton.apply {
            text = item().multiTitle
            isChecked = selectionManager.isSelected(bindingAdapterPosition)
            setOnClickListener {
                selectionManager.toggleSelection(bindingAdapterPosition)
                listener()?.onCellClicked(item())
            }
        }
    }
}
