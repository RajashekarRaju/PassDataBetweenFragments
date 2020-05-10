package com.developersbreach.passdatabetweenfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.developersbreach.passdatabetweenfragments.listToDetail.ListFragment
import com.developersbreach.passdatabetweenfragments.simpleData.FirstFragment
import com.google.android.material.card.MaterialCardView

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        val simpleDataCardView: MaterialCardView = view.findViewById(R.id.simple_data_card_view)
        val listDataCardView: MaterialCardView = view.findViewById(R.id.list_data_card_view)

        simpleDataCardView.setOnClickListener {
            val firstFragment: FirstFragment = FirstFragment.newInstance()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, firstFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        listDataCardView.setOnClickListener {
            val listFragment: ListFragment = ListFragment.newInstance()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, listFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }

}
