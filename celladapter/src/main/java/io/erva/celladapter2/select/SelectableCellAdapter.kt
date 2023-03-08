package io.erva.celladapter2.select

import android.view.ViewGroup
import io.erva.celladapter2.Cell
import io.erva.celladapter2.CellAdapter
import io.erva.celladapter2.select.mode.SelectionManager

class SelectableCellAdapter(
    private val selectedPositions: MutableSet<Int> = HashSet(),
    val selectionManager: SelectionManager
) : CellAdapter() {

    init {
        selectionManager.adapter = this
        selectionManager.selectedPositions = selectedPositions
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cell<*, *, *> {
        val cell = super.onCreateViewHolder(parent, viewType)
        (cell as SelectableCell).selectionManager = selectionManager
        return cell
    }
}
