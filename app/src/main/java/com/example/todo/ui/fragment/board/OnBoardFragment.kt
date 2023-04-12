package com.example.todo.ui.fragment.board

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.todo.App
import com.example.todo.R
import com.example.todo.base.BaseFragment
import com.example.todo.databinding.FragmentOnBoardBinding


class OnBoardFragment : BaseFragment<FragmentOnBoardBinding>(FragmentOnBoardBinding::inflate),BoardAdapter.ClickListener {
    private lateinit var adapter: BoardAdapter

    override fun setupUI() {
        adapter = BoardAdapter(this)
        binding.boardPager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.boardPager)

    }


    override fun click() {
        findNavController().navigate(R.id.noteFragment)

    }

    override fun NextCLicked() {
        binding.boardPager.setCurrentItem(++binding.boardPager.currentItem, true)
    }

    override fun SkipClicked() {
        binding.boardPager.setCurrentItem(binding.boardPager.adapter?.itemCount ?: 0, true)
    }
}

