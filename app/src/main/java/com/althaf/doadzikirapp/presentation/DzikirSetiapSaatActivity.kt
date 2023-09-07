package com.althaf.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.althaf.doadzikirapp.R
import com.althaf.doadzikirapp.adapter.DoaDzikirAdapter
import com.althaf.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.althaf.doadzikirapp.model.DataDoaDzikir

class DzikirSetiapSaatActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirSetiapSaatBinding? = null
    private val binding get() = _binding as ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)

        _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikir())
        binding.rvDzikir.adapter = mAdapter
        binding.rvDzikir.layoutManager = LinearLayoutManager(this)
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