package com.althaf.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.althaf.doadzikirapp.adapter.DoaDzikirAdapter
import com.althaf.doadzikirapp.R
import com.althaf.doadzikirapp.databinding.ActivityPagiBinding
import com.althaf.doadzikirapp.model.DataDoaDzikir

class PagiActivity : AppCompatActivity() {
    private var _binding: ActivityPagiBinding? = null
    private val binding get() = _binding as ActivityPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.dzikir_pagi)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)


        _binding = ActivityPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.apply {
            val mAdapter = DoaDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPagi())
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
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