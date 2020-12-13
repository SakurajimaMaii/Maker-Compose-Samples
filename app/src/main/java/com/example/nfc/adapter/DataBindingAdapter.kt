package com.example.nfc.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.nfc.BR
import com.example.nfc.R

/**
 * 展示类数据绑定Adapter
 * @property items MutableList<BindingAdapterItem>
 * @constructor
 */
class DataBindingAdapter(private var items: MutableList<BindingAdapterItem>):RecyclerView.Adapter<DataBindingAdapter.ViewHolder>() {
    private lateinit var onItemClickListener: OnItemClickListener
    private lateinit var onItemChildClickListener: OnItemChildClickListener
    private lateinit var viewHolder: ViewHolder

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    fun setOnItemChildClickListener(onItemChildClickListener: OnItemChildClickListener){
        this.onItemChildClickListener = onItemChildClickListener
    }

    companion object{

    }

    inner class ViewHolder(val binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: BindingAdapterItem){
            binding.setVariable(BR.item, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ViewDataBinding =DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
        viewHolder = holder
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
        if(holder.binding.root.findViewById<Button>(R.id.sureButton)!=null){
            holder.binding.root.findViewById<Button>(R.id.sureButton).setOnClickListener {
                onItemChildClickListener.onButtonItemClick(holder, position)
            }
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    /**
     * 定义RecyclerView选项单击事件的回调接口
     */
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    /**
     * 设置RecyclerView Item内子控件点击事件
     */
    interface OnItemChildClickListener{
        /**
         * 设置Switch事件
         * @param isChecked Boolean
         */
        fun onSwitchItemClick(isChecked:Boolean,position:Int,holder: ViewHolder)

        /**
         * 修改Switch状态
         * @param position Int
         * @param holder ViewHolder
         */
        fun onSwitchCheckedStatus(position:Int,holder: ViewHolder)

        /**
         * 设置Button事件
         * @param position Int
         * @param holder ViewHolder
         */
        fun onButtonItemClick(holder: ViewHolder, position:Int)
    }
}