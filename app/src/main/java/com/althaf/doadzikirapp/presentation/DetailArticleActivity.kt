package com.althaf.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.althaf.doadzikirapp.R
import com.althaf.doadzikirapp.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private var _binding: ActivityDetailArticleBinding? = null
    private val binding get() = _binding as ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        _binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleArticle = intent.getStringExtra(EXTRA_DATA_TITLE)
        val contentArticle = intent.getStringExtra(EXTRA_DATA_CONTENT)
        val imageArticle = intent.getIntExtra(EXTRA_DATA_IMAGE, 1)

        binding.apply {
            tvDetailTitle.text = titleArticle
            tvDetailContent.text = contentArticle
            imgDetailArticle.setImageResource(imageArticle)
        }
    }

    companion object {
        const val EXTRA_DATA_TITLE = "title"
        const val EXTRA_DATA_CONTENT = "content"
        const val EXTRA_DATA_IMAGE = "image"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}