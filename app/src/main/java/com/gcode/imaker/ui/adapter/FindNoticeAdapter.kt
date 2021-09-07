package com.gcode.imaker.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.donkingliang.labels.LabelsView
import com.gcode.imaker.R
import com.gcode.imaker.ui.model.FindNoticeModel

/**
 *作者:created by HP on 2021/5/22 08:27
 *邮箱:sakurajimamai2020@qq.com
 */
class FindNoticeAdapter(val findNotices:List<FindNoticeModel>):RecyclerView.Adapter<FindNoticeAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView = itemView.findViewById(R.id.fnName)
        val description:TextView = itemView.findViewById(R.id.fnDescription)
        val image:ImageView = itemView.findViewById(R.id.fnImage)
        val lv:LabelsView = itemView.findViewById(R.id.fnLv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.find_notice_model_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = findNotices[position]
        holder.name.text = item.name
        holder.description.text = item.description
        holder.lv.setLabels(item.tag)
        holder.image.setImageDrawable(item.image)
    }

    override fun getItemCount(): Int {
        return findNotices.size
    }
}