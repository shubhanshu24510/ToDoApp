package com.example.todoapp

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicquizapp.R
import kotlinx.android.synthetic.main.layout_view.view.my_layout
import kotlinx.android.synthetic.main.layout_view.view.priority
import kotlinx.android.synthetic.main.layout_view.view.title
import java.util.Locale

class Adapter(private var data:List<CardInfo>):RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var title =itemView.title
        var priority=itemView.priority
        var layout=itemView.my_layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.layout_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(data[position].priority.toLowerCase(Locale.ROOT))
        {
            "high"->holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium"->holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            else->holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
        }
        holder.title.text=data[position].title
        holder.priority.text=data[position].priority
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}