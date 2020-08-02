package com.developersbreach.passdatabetweenfragments.listToDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.passdatabetweenfragments.R
import com.developersbreach.passdatabetweenfragments.listToDetail.DetailFragment.Companion.SPORTS_DATA_BUNDLE_KEY
import com.developersbreach.passdatabetweenfragments.listToDetail.DetailFragment.Companion.SPORTS_DATA_REQUEST_KEY


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SportsAdapter

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar_list_fragment)
        recyclerView = view.findViewById(R.id.recycler_view)
        val sportsList = Sports.sportsList(requireContext())
        adapter = SportsAdapter(sportsList, sportsItemListener)
        recyclerView.adapter = adapter

        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }

    private val sportsItemListener = SportsAdapter.OnClickListener { sports ->
        val result: Sports = sports
        setFragmentResult(SPORTS_DATA_REQUEST_KEY, bundleOf(SPORTS_DATA_BUNDLE_KEY to result))

        val detailFragment: DetailFragment = DetailFragment.newInstance()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, detailFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
