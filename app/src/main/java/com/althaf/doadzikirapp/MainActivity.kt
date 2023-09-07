package com.althaf.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.althaf.doadzikirapp.adapter.ArticleAdapter
import com.althaf.doadzikirapp.databinding.ActivityMainBinding
import com.althaf.doadzikirapp.model.ArticleItem
import com.althaf.doadzikirapp.presentation.DetailArticleActivity
import com.althaf.doadzikirapp.presentation.DzikirHarianActivity
import com.althaf.doadzikirapp.presentation.DzikirSetiapSaatActivity
import com.althaf.doadzikirapp.presentation.pagipetang.PagiPetangActivity
import com.althaf.doadzikirapp.presentation.QauliyahShalatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayOf<ImageView?>()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for (i in initData().indices) {
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.inactive_dot)
                )
            }
            dotSliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.active_dot)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        initView()
        setupViewPager()
    }

    private fun setupViewPager() {
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices) {
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.inactive_dot)
            )

            val params = LinearLayoutCompat.LayoutParams(35, 35)
            params.marginStart = 8
            params.marginEnd = 8
            binding.dots.addView(dotSliderIndicator[i], params)
        }
    }

    private fun initView() {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardQauliyahShalat.setOnClickListener(this)
        binding.cardDzikir.setOnClickListener(this)
        binding.cardDzikirHarian.setOnClickListener(this)
        binding.cardPagiPetang.setOnClickListener(this)

        val mAdapter = ArticleAdapter()
        mAdapter.setData(initData())
        mAdapter.setOnItemClickCallback(object : ArticleAdapter.OnItemCallback {
            override fun onItemClicked(item: ArticleItem) {
                val intent = Intent(applicationContext, DetailArticleActivity::class.java)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE, item.titleArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_CONTENT, item.contentArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_IMAGE, item.imageArticle)
                startActivity(intent)
            }
        })
        binding.vpArticle.adapter = mAdapter
        binding.vpArticle.registerOnPageChangeCallback(slidingCallback)
    }

    private fun initData(): List<ArticleItem> {
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArticle = resources.obtainTypedArray(R.array.arr_img_artikel)

        val listData = arrayListOf<ArticleItem>()
        for (i in titleArticle.indices) {
            val data = ArticleItem(
                titleArticle[i],
                imageArticle.getResourceId(i, 0),
                contentArticle[i]
            )
            listData.add(data)
        }
        imageArticle.recycle()

        return listData
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.card_qauliyah_shalat -> startActivity(
                Intent(
                    this,
                    QauliyahShalatActivity::class.java
                )
            )

            R.id.card_dzikir -> startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
            R.id.card_dzikir_harian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
            R.id.card_pagi_petang -> startActivity(Intent(this, PagiPetangActivity::class.java))
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}