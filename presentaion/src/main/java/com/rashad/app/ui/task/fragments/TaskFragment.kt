package com.rashad.app.ui.splash.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rashad.app.ui.splash.viewmodels.SplashViewModel
import com.rashad.app.base.views.BaseFragmentViewBinding
import com.rashad.app.databinding.TaskFragmentBinding
import com.rashad.app.session.SessionManager
import com.rashad.app.utils.extensions.authActivityComponent
import es.dmoral.toasty.Toasty
import javax.inject.Inject

class TaskFragment : BaseFragmentViewBinding<TaskFragmentBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val splashViewModel: SplashViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onBind(inflater: LayoutInflater, container: ViewGroup?): TaskFragmentBinding {
        authActivityComponent.inject(this@TaskFragment)
        return TaskFragmentBinding.inflate(inflater, container, false)
    }

    @SuppressLint("TimberArgCount")
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        splashViewModel.ready.observe(viewLifecycleOwner) {
            if (it) {
                if (sessionManager.isRememberMe()) {

                    Toasty.success(requireContext(), "success").show()
                } else {
                    findNavController().popBackStack()
                }
            }
        }
    }


}