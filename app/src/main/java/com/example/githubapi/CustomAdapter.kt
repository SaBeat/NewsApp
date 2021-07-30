package com.example.githubapi


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapi.model.Article
import com.example.githubapi.utils.Utils
import kotlinx.android.synthetic.main.item_row.view.*

class CustomAdapter(val context: Context) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    lateinit var intent: Intent
    var list = ArrayList<Article>()

    fun setDataList(list: ArrayList<Article>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
        holder.cardView.setOnClickListener {
            intent = Intent(context, DetailedActivity::class.java)
            intent.putExtra(Utils.title,list.get(position).title)
           // intent.putExtra(Utils.descripton,list.get(position).description)
            intent.putExtra(Utils.image,list.get(position).urlToImage)
            intent.putExtra(Utils.url,list.get(position).url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.text_title
        var date = view.text_release_date
        var image = view.imageView
        var cardView=view.cardView

        fun bind(article: Article) {
            date.text = article.publishedAt
            title.text = article.title
            Glide.with(image).load(article.urlToImage).into(image)

        }
    }

}