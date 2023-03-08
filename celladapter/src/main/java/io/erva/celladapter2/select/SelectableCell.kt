package io.erva.celladapter2.select

import androidx.viewbinding.ViewBinding
import io.erva.celladapter2.Cell

import io.erva.celladapter2.select.mode.SelectionManager

abstract class SelectableCell<ITEM : Any, VB : ViewBinding, out LISTENER : Cell.Listener<ITEM>>(
    binding: VB
) : Cell<ITEM, VB, LISTENER>(binding) {

    lateinit var selectionManager: SelectionManager
}
