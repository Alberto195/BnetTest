package com.example.binettest.presentation.entry_list.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.binettest.R
import com.example.binettest.data.entry_list.models.EntryDataListModel

class EntryListAdapter(
    private val listener: EntryHolder.Listener
    ): RecyclerView.Adapter<EntryListAdapter.EntryHolder>() {

    private var entryList = EntryDataListModel(null, 0)

    class EntryHolder(
        view: View,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(view) {

        private val dateEntryAdded: TextView = view.findViewById(R.id.date_added)
        private val dateEntryModified: TextView = view.findViewById(R.id.date_modified)
        private val body: TextView = view.findViewById(R.id.body)
        private val cardView: CardView = view.findViewById(R.id.entry_item)

        interface Listener {
            fun onClick(dateAdded: String, dateModified: String, bodyText: String)
        }

        fun bind(dateAdded: String, dateModified: String, bodyText: String) {
            if(dateAdded != dateModified) {
                dateEntryModified.text = dateModified
            }

            dateEntryAdded.text = dateAdded
            body.text = bodyText.take(200)

            cardView.setOnClickListener {
                listener.onClick(dateAdded, dateModified, bodyText)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return EntryHolder(view, listener)
    }

    override fun onBindViewHolder(holder: EntryHolder, position: Int) {
        if(entryList.data!![0].isNotEmpty()) {
            holder.bind(
                entryList.data!![0][position].da,
                entryList.data!![0][position].dm,
                entryList.data!![0][position].body
            )
        }
    }

    override fun getItemCount(): Int {
        return if (entryList.data != null) {
            entryList.data!![0].size
        } else {
            0
        }
    }

    fun setList(list: EntryDataListModel) {
        entryList = list
        notifyDataSetChanged()
    }
}