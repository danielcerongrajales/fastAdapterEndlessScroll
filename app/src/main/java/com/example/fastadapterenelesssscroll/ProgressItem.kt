package com.example.fastadapterenelesssscroll

import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.items.AbstractItem

class ProgressItem : AbstractItem<ProgressItem.ViewHolder>() {

    override val type: Int
        get() = R.id.progress_bar

    override val layoutRes: Int
        get() = R.layout.progress_item

    override fun bindView(holder: ViewHolder, payloads: List<Any>) {
        super.bindView(holder, payloads)
        if (isEnabled) {

//            holder.itemView.setBackgroundResource(R.color.purple_200)
        }
    }

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var progressBar: ProgressBar = view.findViewById(R.id.progress_bar)

    }
}