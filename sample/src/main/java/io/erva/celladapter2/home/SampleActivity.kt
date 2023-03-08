package io.erva.celladapter2.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.erva.celladapter2.CellAdapter
import io.erva.celladapter2.DividerItemDecoration
import io.erva.celladapter2.R
import io.erva.celladapter2.base.BaseSampleActivity
import io.erva.celladapter2.databinding.ActivityWithRecyclerViewBinding
import io.erva.celladapter2.databinding.ItemSimpleBinding
import io.erva.celladapter2.multi.MultiChoiceActivity
import io.erva.celladapter2.single.SingleChoiceActivity

class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWithRecyclerViewBinding

    private var cellAdapter: CellAdapter = CellAdapter().apply {
        cell(
            cell = MenuItemCell::class,
            binding = ItemSimpleBinding::class.java,
            model = MenuItemModel::class
        ) { item -> startActivity(Intent(this@SampleActivity, (item as MenuItemModel).clazz)) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.app_name)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context))
            adapter = cellAdapter
        }

        cellAdapter.items.addAll(
            arrayOf(
                MenuItemModel(R.string.sample_base, BaseSampleActivity::class.java),
                MenuItemModel(R.string.sample_single_choice, SingleChoiceActivity::class.java),
                MenuItemModel(R.string.sample_multi_choice, MultiChoiceActivity::class.java)
            )
        )
        cellAdapter.notifyItemRangeChanged(0, cellAdapter.itemCount)
    }
}
