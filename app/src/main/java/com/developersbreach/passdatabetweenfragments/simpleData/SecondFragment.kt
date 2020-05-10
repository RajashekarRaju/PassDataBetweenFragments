package com.developersbreach.passdatabetweenfragments.simpleData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.developersbreach.passdatabetweenfragments.R

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    companion object {

        const val STRING_DATA_REQUEST_KEY: String = "STRING_DATA_REQUEST_KEY_VALUE"
        const val STRING_DATA_BUNDLE_KEY: String = "STRING_DATA_BUNDLE_KEY_VALUE"

        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_second, container, false)

        val textView: TextView = view.findViewById(R.id.second_text_view)
        setFragmentResultListener(STRING_DATA_REQUEST_KEY) { resultKey, bundle ->
            val result: Any? = bundle.get(STRING_DATA_BUNDLE_KEY) as String
            textView.text = result.toString()
        }

        return view
    }

}
