package io.erva.celladapter2.multi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.erva.celladapter2.CellAdapter
import io.erva.celladapter2.DividerItemDecoration
import io.erva.celladapter2.databinding.ActivityWithRecyclerViewBinding
import io.erva.celladapter2.databinding.ItemMultiBinding
import io.erva.celladapter2.select.SelectableCellAdapter
import io.erva.celladapter2.select.mode.MultiSelectionManager

class MultiChoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWithRecyclerViewBinding
    private val multiSelectionManager = MultiSelectionManager()

    private var cellAdapter: CellAdapter = SelectableCellAdapter(selectionManager = multiSelectionManager, selectedPositions = mutableSetOf()).apply {
        cell(
            cell = MultiChoiceCell::class,
            binding = ItemMultiBinding::class.java,
            model = MultiChoiceModel::class
        ) {
            supportActionBar?.subtitle = "Selected ${multiSelectionManager.getSelectedPositions()}"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context))
            adapter = cellAdapter
        }

        for (it in 0..33) {
            cellAdapter.addItem(MultiChoiceModel("Multi select $it"))
        }
        cellAdapter.notifyItemRangeChanged(0, cellAdapter.itemCount)

        supportActionBar?.subtitle = "Selected ${multiSelectionManager.getSelectedPositions()}"
    }
}
