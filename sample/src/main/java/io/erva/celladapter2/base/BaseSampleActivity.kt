package io.erva.celladapter2.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.erva.celladapter2.CellAdapter
import io.erva.celladapter2.DividerItemDecoration
import io.erva.celladapter2.base.cell.AlphaCell
import io.erva.celladapter2.base.cell.BetaCell
import io.erva.celladapter2.base.cell.GammaCell
import io.erva.celladapter2.base.model.AlphaModel
import io.erva.celladapter2.base.model.BetaModel
import io.erva.celladapter2.base.model.GammaModel
import io.erva.celladapter2.databinding.*

class BaseSampleActivity : AppCompatActivity() {

    private var cellAdapter: CellAdapter = CellAdapter().apply {
        cell(
            cell = AlphaCell::class,
            binding = ItemBaseAlphaBinding::class.java,
            model = AlphaModel::class,
            listener = object : AlphaCell.Listener {
                override fun onPressOne(item: AlphaModel) {
                    showToast(String.format("%s%npress button %d", item.text, 1))
                }

                override fun onPressTwo(item: AlphaModel) {
                    showToast(String.format("%s%npress button %d", item.text, 2))
                }

                override fun onCellClicked(item: AlphaModel) {
                    showToast(item.text)
                }
            })
        cell(
            cell = BetaCell::class,
            binding = ItemBaseBetaBinding::class.java,
            model = BetaModel::class,
            listener = object : BetaCell.Listener {
                override fun onCellClicked(item: BetaModel) {
                    showToast(item.text)
                }
            })
        cell(
            cell = GammaCell::class,
            binding = ItemBaseGammaBinding::class.java,
            model = GammaModel::class
        )
    }

    private lateinit var binding: ActivityWithRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context))
            adapter = cellAdapter
        }

        for (i in 0..33) {
            cellAdapter.items.add(AlphaModel("AlphaModel $i"))
            cellAdapter.items.add(BetaModel("BetaModel $i"))
            cellAdapter.items.add(GammaModel("GammaModel $i"))
        }
        cellAdapter.notifyItemRangeChanged(0, cellAdapter.items.size)
    }

    private var toast: Toast? = null
    private fun showToast(text: String) {
        toast?.cancel()
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT).apply { show() }
    }
}
