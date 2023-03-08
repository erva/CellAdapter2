package io.erva.celladapter2

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import io.erva.celladapter2.Cell.Listener

abstract class Cell<ITEM : Any, VB : ViewBinding, out LISTENER : Listener<ITEM>>(binding: VB) :
    RecyclerView.ViewHolder(binding.root) {

    var item: Any? = null
        set(value) {
            field = value
            bindView()
        }
    private var listener: Any? = null

    init {
        binding.root.setOnClickListener { listener()?.onCellClicked(item()) }
    }

    abstract fun bindView()

    @Suppress("UNCHECKED_CAST")
    fun item(): ITEM {
        return item as ITEM
    }

    fun item(item: Any) {
        this.item = item
    }

    @Suppress("UNCHECKED_CAST")
    fun listener(): LISTENER? {
        return listener as LISTENER?
    }

    fun listener(listener: Any?) {
        this.listener = listener
    }

    fun interface Listener<ITEM : Any> {
        fun onCellClicked(item: ITEM)
    }
}