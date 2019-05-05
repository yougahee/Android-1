package com.icoo.sopkaton_5.ui.main.home

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.keyword.KeywordModel
import com.icoo.sopkaton_5.data.model.test.TestModel
import com.icoo.sopkaton_5.util.IIdxClickListener

class HomeRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<KeywordModel>) :
    RecyclerView.Adapter<HomeRecyclerViewAdapter.Holder>() {

    private var listener: IIdxClickListener? = null

    fun setOnItemClickListener(listener: IIdxClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_home_contents, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.setOnClickListener {
            if (listener != null) {
                listener!!.onItemClick(dataList[position].keywordIdx)
            }
        }
//        Glide.with(holder.img).load(dataList[position].img).into(holder.img)
        holder.tag.text = "#${dataList[position].content}"
        holder.term.text = dataList[position].endDate
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view: CardView = itemView.findViewById(R.id.rv_home_contents_cv_root_view) as CardView
//        val img: ImageView = itemView.findViewById(R.id.rv_home_contents_iv) as ImageView
        val tag: TextView = itemView.findViewById(R.id.rv_home_contents_tv_tag) as TextView
        val term: TextView = itemView.findViewById(R.id.rv_home_contents_tv_term) as TextView
    }
}