package com.rashad.app.base.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseRoundCornerBottomSheetDialogFragment<BINDING : ViewBinding> :
  BottomSheetDialogFragment() {

  private var _binding: BINDING? = null
  protected val binding get() = _binding!!
  protected val disposables = CompositeDisposable()

  protected abstract fun onBind(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): BINDING

  @CallSuper
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = onBind(inflater, container)
    return binding.root
  }

  @CallSuper
  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
  }

  fun add(disposable: Disposable) {
    disposables.add(disposable)
  }

  fun Disposable.addDisposable() {
    this.addTo(disposables)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
    disposables.dispose()
  }

  fun onBackButtonPressed() {
    // TODO handle back press
  }
}