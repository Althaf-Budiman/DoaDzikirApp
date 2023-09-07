package com.althaf.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.althaf.doadzikirapp.adapter.DoaDzikirAdapter
import com.althaf.doadzikirapp.R
import com.althaf.doadzikirapp.databinding.ActivityDzikirHarianBinding
import com.althaf.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.althaf.doadzikirapp.model.DoaDzikirItem

class DzikirHarianActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirHarianBinding? = null
    private val binding get() = _binding as ActivityDzikirHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)


        _binding = ActivityDzikirHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirDatas()
        initView()
    }

    private fun initView() {
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(providingDzikirDatas())

        binding.rvDzikirHarian.adapter = mAdapter
        binding.rvDzikirHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirDatas(): List<DoaDzikirItem> {
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikirItem>()
        for (i in titleDzikir.indices) {
            val data = DoaDzikirItem(
                titleDzikir[i],
                arabicDzikir[i],
                translateDzikir[i]
            )
            listData.add(data)
        }

        return listData
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