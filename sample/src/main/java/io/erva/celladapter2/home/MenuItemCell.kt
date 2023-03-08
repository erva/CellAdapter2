package io.erva.celladapter2.home

import io.erva.celladapter2.Cell
import io.erva.celladapter2.databinding.ItemSimpleBinding

class MenuItemCell(private val binding: ItemSimpleBinding) :
    Cell<MenuItemModel, ItemSimpleBinding, Cell.Listener<MenuItemModel>>(binding) {

    override fun bindView() {
        val item = item()
        binding.text.setText(item.titleId)
    }
}
