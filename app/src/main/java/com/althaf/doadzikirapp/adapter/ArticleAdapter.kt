package com.althaf.doadzikirapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaf.doadzikirapp.databinding.ItemArticleBinding
import com.althaf.doadzikirapp.model.ArticleItem

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private var listArticle = ArrayList<ArticleItem>()
    private var onItemCallback: OnItemCallback? = null

    fun setData(list: List<ArticleItem>) {
        listArticle.clear()
        listArticle.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }

    inner class ArticleViewHolder(val view: ItemArticleBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArticle[position]
        holder.view.itemArticle.setImageResource(data.imageArticle)
        holder.itemView.setOnClickListener {
            onItemCallback?.onItemClicked(data)

            /* it.context.apply {
                val intent = Intent(this, DetailArticleActivity::class.java)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE, data.titleArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_CONTENT, data.contentArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_IMAGE, data.imageArticle)
                startActivity(intent)
            } */
        }
    }

    interface OnItemCallback {
        fun onItemClicked(item: ArticleItem)
    }
}