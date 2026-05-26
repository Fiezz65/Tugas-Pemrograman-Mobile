package com.example.recyclerview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val itemList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val defaultIcon = android.R.drawable.ic_menu_gallery

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon: ImageView = view.findViewById(R.id.ivIcon)
        val tvImageLabel: TextView = view.findViewById(R.id.tvImageLabel)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val switchItem: SwitchCompat = view.findViewById(R.id.switchItem)
        val btnAction: Button = view.findViewById(R.id.btnAction)
        val itemContainer: View = view.findViewById(R.id.itemContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        val itemNumber = position + 1
        val context = holder.itemView.context

        with(holder) {
            tvImageLabel.text = item.imageLabel
            ivIcon.setImageResource(item.imageResId ?: defaultIcon)
            tvTitle.text = item.title
            tvDescription.text = item.description

            itemContainer.setBackgroundColor(
                if (itemNumber % 2 == 0) ContextCompat.getColor(context, R.color.alt_row) else Color.TRANSPARENT
            )

            switchItem.setOnCheckedChangeListener(null)
            switchItem.isChecked = false
            switchItem.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    showToastOnce(
                        context,
                        item.isSwitchToastShown,
                        "Switch hidup pada item $itemNumber"
                    ) { item.isSwitchToastShown = true }
                }
            }

            itemContainer.setOnClickListener {
                switchItem.isChecked = !switchItem.isChecked
                showToastOnce(
                    context,
                    item.isClickToastShown,
                    "Item telah ditekan untuk $itemNumber"
                ) { item.isClickToastShown = true }
            }

            btnAction.setOnClickListener {
                showToastOnce(
                    context,
                    item.isButtonToastShown,
                    "Tombol telah ditekan untuk tombol $itemNumber"
                ) { item.isButtonToastShown = true }
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    private fun showToastOnce(context: Context, isShown: Boolean, message: String, markShown: () -> Unit) {
        if (isShown) return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        markShown()
    }
}