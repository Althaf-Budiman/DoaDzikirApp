package com.althaf.doadzikirapp.presentation.pagipetang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.althaf.doadzikirapp.R
import com.althaf.doadzikirapp.databinding.ActivityPagiPetangBinding

class PagiPetangActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityPagiPetangBinding? = null
    private val binding get() = _binding as ActivityPagiPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)

        _binding = ActivityPagiPetangBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi)
//        val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang)

        binding.imgBtnDzikirPagi.setOnClickListener(this)
        binding.imgBtnDzikirPetang.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, PagiActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this, PetangActivity::class.java))
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