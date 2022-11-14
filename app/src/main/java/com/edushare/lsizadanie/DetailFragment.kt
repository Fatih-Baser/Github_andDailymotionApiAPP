package com.edushare.lsizadanie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs


import com.edushare.lsizadanie.databinding.FragmentDetailBinding

class DetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentDetailBinding.inflate(inflater).run {

            val args: DetailFragmentArgs by navArgs()
           this.user = args.user
            return root
        }
    }
}