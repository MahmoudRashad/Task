package com.rashad.app.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseViewModel : ViewModel() {

  private val disposables = CompositeDisposable()

  fun add(disposable: Disposable) {
    disposables.add(disposable)
  }

  protected fun Disposable.addDisposable() {
    this.addTo(disposables)
  }

  private fun dispose() {
    if (!disposables.isDisposed)
      disposables.dispose()
      disposables.clear()
  }

  @CallSuper
  override fun onCleared() {
    super.onCleared()
    disposables.clear()
  }
}