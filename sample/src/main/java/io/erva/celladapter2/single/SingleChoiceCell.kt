package io.erva.celladapter2.single

import io.erva.celladapter2.Cell
import io.erva.celladapter2.databinding.ItemSingleBinding
import io.erva.celladapter2.select.SelectableCell

class SingleChoiceCell(private val binding: ItemSingleBinding) :
    SelectableCell<SingleChoiceModel, ItemSingleBinding, Cell.Listener<SingleChoiceModel>>(binding) {

    override fun bindView() {
        binding.radioButton.apply {
            text = item().singleTitle
            isChecked = selectionManager.isSelected(bindingAdapterPosition)
            setOnClickListener {
                selectionManager.toggleSelection(bindingAdapterPosition)
                listener()?.onCellClicked(item())
            }
        }
    }
}
