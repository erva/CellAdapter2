package io.erva.celladapter2

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import io.erva.celladapter2.Cell.Listener
import kotlin.reflect.KClass

open class CellAdapter :
    RecyclerView.Adapter<Cell<out Any, *, Listener<out Any>>>() {

    private val itemCellMapping = HashMap<KClass<*>,
            Pair<KClass<out Cell<out Any, *, Listener<out Any>>>, Class<out ViewBinding>>>()
    private val viewTypes: MutableList<KClass<*>> = mutableListOf()
    private val itemListenerMapping = SparseArray<Listener<out Any>>()

    val items: MutableList<Any> = mutableListOf()

    open fun cell(
        cell: KClass<out Cell<out Any, *, Listener<out Any>>>,
        binding: Class<out ViewBinding>,
        model: KClass<*>,
        listener: Listener<out Any>? = null
    ): CellAdapter {
        itemCellMapping[model] = Pair(cell, binding)
        val type = viewTypes.indexOf(model)
        if (type == -1) {
            this.viewTypes.add(model)
            listener?.let {
                itemListenerMapping.put(viewTypes.indexOf(model), it)
            }
        }
        return this
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Cell<out Any, *, Listener<out Any>> {
        val cellClass = itemCellMapping[viewTypes[viewType]]!!
        val bindingClass = cellClass.second
        val inflateMethod = bindingClass.declaredMethods.filter { it.name == "inflate" }[1]
        val binding = inflateMethod.invoke(null, LayoutInflater.from(parent.context), parent, false)
        return cellClass.first.constructors.first().call(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val baseItemClass = this.items[position]
        val index = viewTypes.indexOf(baseItemClass.javaClass.kotlin)
        if (index < 0) {
            throw IllegalArgumentException(baseItemClass.javaClass.simpleName + " is not registered")
        }
        return index
    }

    override fun onBindViewHolder(
        cell: Cell<out Any, *, Listener<out Any>>,
        position: Int
    ) {
        val item = getItem(position)
        cell.listener(itemListenerMapping.get(getItemViewType(position)))
        cell.item(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    operator fun contains(item: Any): Boolean {
        return items.contains(item)
    }

    fun indexOf(item: Any): Int {
        return items.indexOf(item)
    }

    fun replaceItem(position: Int, item: Any) {
        items[position] = item
    }

    fun getItem(position: Int): Any {
        return items[position]
    }

    fun addItem(item: Any) {
        items.add(item)
    }

    fun addItem(position: Int, item: Any) {
        items.add(position, item)
    }

    fun addItems(items: List<Any>?) {
        if (items != null) {
            this.items.addAll(items)
        }
    }

    fun remove(item: Any?) {
        items.remove(item)
    }

    fun remove(position: Int) {
        items.removeAt(position)
    }

    fun clear() {
        items.clear()
    }
}
