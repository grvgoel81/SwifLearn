package com.example.swiflearn.ui.slideshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swiflearn.R
import com.example.swiflearn.model.PastClassInfo
import kotlinx.android.synthetic.main.item_past_class.view.*

/**
 * Created by gauravgoel on 02/August/2020
 */
class PastClassAdapter : RecyclerView.Adapter<PastClassAdapter.ClassViewHolder>() {

    private var pastClassInfoList = mutableListOf<PastClassInfo>()

    inner class ClassViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(pastClassInfo: PastClassInfo) {
            with(view) {
                tvSubjectName.text = pastClassInfo.subjectName
                tvTopic.text = pastClassInfo.topic
                tvDateTime.text = pastClassInfo.date
                tvTeacherName.text = pastClassInfo.teacherName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClassViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_past_class, parent, false
        )
    )

    override fun getItemCount(): Int = pastClassInfoList?.size!!

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        pastClassInfoList?.get(position)?.let { holder.bind(it) }
    }

    fun bindItems(items: List<PastClassInfo>) {
        this.pastClassInfoList.clear()
        this.pastClassInfoList.addAll(items)
        notifyDataSetChanged()
    }
}