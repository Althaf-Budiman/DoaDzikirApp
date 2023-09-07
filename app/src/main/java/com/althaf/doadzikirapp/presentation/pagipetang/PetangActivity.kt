package com.althaf.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.althaf.doadzikirapp.R
import com.althaf.doadzikirapp.databinding.ActivityPetangBinding

class PetangActivity : AppCompatActivity() {
    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)

        _binding = ActivityPetangBinding.inflate(layoutInflater)

        setContentView(binding.root)
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