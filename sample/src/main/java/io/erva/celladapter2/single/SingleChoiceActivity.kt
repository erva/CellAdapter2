package io.erva.celladapter2.single

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.erva.celladapter2.CellAdapter
import io.erva.celladapter2.DividerItemDecoration
import io.erva.celladapter2.databinding.ActivityWithRecyclerViewBinding
import io.erva.celladapter2.databinding.ItemSingleBinding
import io.erva.celladapter2.select.SelectableCellAdapter
import io.erva.celladapter2.select.mode.SingleSelectionManager

class SingleChoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWithRecyclerViewBinding
    private val singleSelectionManager = SingleSelectionManager()

    private var cellAdapter: CellAdapter = SelectableCellAdapter(selectionManager = singleSelectionManager).apply {
        cell(
            cell = SingleChoiceCell::class,
            binding = ItemSingleBinding::class.java,
            model = SingleChoiceModel::class
        ) {
            supportActionBar?.subtitle = "Selected ${singleSelectionManager.getSelectedPosition()}"
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
            cellAdapter.addItem(SingleChoiceModel("Single select $it"))
        }
        cellAdapter.notifyItemRangeChanged(0, cellAdapter.itemCount)

        supportActionBar?.subtitle = String.format("Selected %d", singleSelectionManager.getSelectedPosition())
    }
}
