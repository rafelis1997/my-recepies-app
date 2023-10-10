package com.rafelis1997.minhasreceitasapp.presentation.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.rafelis1997.minhasreceitasapp.R
import com.rafelis1997.minhasreceitasapp.databinding.FragmentFirstBinding
import com.rafelis1997.minhasreceitasapp.presentation.dialog.DialogEditTextFragment
import com.rafelis1997.minhasreceitasapp.presentation.recipe.adapter.RecipeAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecipeFragment : Fragment() {

    private val viewModel: RecipesViewModel by viewModels {
        RecipesViewModel.Factory()
    }

    private lateinit var binding: FragmentFirstBinding

    private val adapter by lazy { RecipeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupAdapter()
        observeStates()
    }

    fun setupListeners() {
        binding.fabRecipe.setOnClickListener {
            showDialog()
        }
        setFragmentResultListener(DialogEditTextFragment.FRAGMENT_RESULT) { requestKey: String, bundle ->
            val nameRecipe = bundle.getString(DialogEditTextFragment.EDIT_TEXT_VALUE) ?: ""
            if (nameRecipe.isNotEmpty()) {
                viewModel.insert(nameRecipe)
            }
        }
        adapter.click = { recipeItem ->
            Log.d("RecipeItem", recipeItem.toString())
            val action = RecipeFragmentDirections.actionRecipeFragmentToDetailFragment(
                recipeItem.id
            )
            findNavController().navigate(action)
        }
    }

    fun setupAdapter() {
        binding.rvRecipes.adapter = adapter
    }

    private fun observeStates() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when(state) {
                RecipeState.Loading -> {
                    binding.pbLoading.isVisible = true
                }
                RecipeState.Empty -> {
                    binding.pbLoading.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.label_empty_recipes),
                        Toast.LENGTH_LONG
                    ).show()
                }
                is RecipeState.Error -> {
                    binding.pbLoading.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        state.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
                is RecipeState.Success -> {
                    binding.pbLoading.isVisible = false
                    adapter.submitList(state.recipe)
                }
            }
        }
    }

    private fun showDialog() {
        DialogEditTextFragment.show(
            title = getString(R.string.title_new_recipe),
            placeHolder = getString(R.string.label_name_recipe),
            fragmentManager = parentFragmentManager,
        )
    }

    fun <T> Flow<T>.observe(owner: LifecycleOwner, observe: (T) -> Unit) {
        owner.lifecycleScope.launch {
            owner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@observe.collect(observe)
            }
        }
    }
}