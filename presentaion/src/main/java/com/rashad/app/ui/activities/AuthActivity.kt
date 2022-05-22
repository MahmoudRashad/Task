package com.rashad.app.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rashad.app.TaskAPP
import com.rashad.app.databinding.ActivityAuthBinding
import com.rashad.app.di.activity.ActivitySubComponent

class AuthActivity : AppCompatActivity() {

    lateinit var binding: ActivityAuthBinding
    val activitySubComponent: ActivitySubComponent by lazy {
        TaskAPP.get(this).appComponent.getActivitySubComponent().create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activitySubComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}