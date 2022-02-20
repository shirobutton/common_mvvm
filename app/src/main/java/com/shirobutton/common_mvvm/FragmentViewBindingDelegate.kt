package com.shirobutton.common_mvvm

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T: ViewBinding>Fragment.viewBinding(viewBinder: (View) -> T): ReadOnlyProperty<Fragment, T?> =
    FragmentViewBindingDelegate { view?.let(viewBinder) }

private class FragmentViewBindingDelegate<T: ViewBinding>(
    private val bindingProvider: () -> T?
): ReadOnlyProperty<Fragment, T?> {

    private var binding: T? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>) =
        binding ?: thisRef.viewLifecycleOwnerLiveData.value?.lifecycle?.let{
            if(!it.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) return null
            it.addObserver(object: DefaultLifecycleObserver {
                override fun onDestroy(owner: LifecycleOwner) {
                    super.onDestroy(owner)
                    binding = null
                }
            })
            binding = bindingProvider()
            binding
        }
}