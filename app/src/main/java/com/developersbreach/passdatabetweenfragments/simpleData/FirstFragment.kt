package com.developersbreach.passdatabetweenfragments.simpleData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import com.developersbreach.passdatabetweenfragments.R
import com.developersbreach.passdatabetweenfragments.simpleData.SecondFragment.Companion.STRING_DATA_BUNDLE_KEY
import com.developersbreach.passdatabetweenfragments.simpleData.SecondFragment.Companion.STRING_DATA_REQUEST_KEY
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_first, container, false)

        val editText: TextInputEditText = view.findViewById(R.id.edit_text)
        val button: Button = view.findViewById(R.id.pass_data_button)
        button.setOnClickListener {

            val data: String = editText.text.toString()
            setFragmentResult(STRING_DATA_REQUEST_KEY, bundleOf(STRING_DATA_BUNDLE_KEY to data))

            val secondFragment: SecondFragment = SecondFragment.newInstance()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, secondFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }

}
