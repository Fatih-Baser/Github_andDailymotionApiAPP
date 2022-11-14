package com.edushare.lsizadanie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.edushare.lsizadanie.databinding.FragmentFeedBinding
import dagger.hilt.android.AndroidEntryPoint
import eu.adamgiergun.lsi.util.ClickListener

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val usersListViewModel: FeedFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFeedBinding.inflate(inflater).let { binding ->
        val usersAdapter = UsersAdapter(
            ClickListener { user ->
                findNavController().navigate(
                    FeedFragmentDirections
                        .actionFeedFragmentToDetailFragment(user)
                )
            }
        )

        binding.usersRecycler.adapter = usersAdapter

        usersListViewModel.usersList.observe(viewLifecycleOwner) { usersList ->
            if (!usersList.isNullOrEmpty())
                usersAdapter.submitList(usersList)
        }

        binding.root
    }
}