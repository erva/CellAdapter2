package io.erva.celladapter2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.erva.celladapter2.Cell.Listener
import io.erva.celladapter2.cell.AlphaCell
import io.erva.celladapter2.cell.BetaCell
import io.erva.celladapter2.cell.GammaCell
import io.erva.celladapter2.databinding.ActivityMainBinding
import io.erva.celladapter2.databinding.ItemAlphaBinding
import io.erva.celladapter2.databinding.ItemBetaBinding
import io.erva.celladapter2.databinding.ItemGammaBinding
import io.erva.celladapter2.model.AlphaModel
import io.erva.celladapter2.model.BetaModel
import io.erva.celladapter2.model.GammaModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var cellAdapter: CellAdapter = CellAdapter().apply {
        cell(
            cell = AlphaCell::class,
            binding = ItemAlphaBinding::class.java,
            model = AlphaModel::class,
            listener = object : AlphaCell.CustomAlphaListener {
                override fun onPressOne(item: AlphaModel) {
                    showToast("Button 1 click, ${item.alpha}")
                }

                override fun onPressTwo(item: AlphaModel) {
                    showToast("Button 2 click, ${item.alpha}")
                }

                override fun onCellClicked(item: AlphaModel) {
                    showToast(item.alpha)
                }

            }
        )
        cell(
            cell = BetaCell::class,
            binding = ItemBetaBinding::class.java,
            model = BetaModel::class
            // listener may be not provided
        )
        cell(
            cell = GammaCell::class,
            binding = ItemGammaBinding::class.java,
            model = GammaModel::class,
            listener = object : Listener<GammaModel> {
                override fun onCellClicked(item: GammaModel) {
                    showToast(item.gamma)
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity,
                RecyclerView.VERTICAL))
            adapter = cellAdapter
        }

        for (i in 0..33) {
            cellAdapter.items.add(AlphaModel(String.format("AlphaModel %d", i)))
            cellAdapter.items.add(BetaModel(String.format("BetaModel %d", i)))
            cellAdapter.items.add(GammaModel(String.format("GammaModel %d", i)))
        }
        cellAdapter.notifyDataSetChanged()
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
