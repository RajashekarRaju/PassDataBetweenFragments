package com.developersbreach.passdatabetweenfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    companion object {
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
        setFragmentResultListener("data_key") { resultKey, bundle ->
            val result: Any? = bundle.get("bundle_key") as String
            textView.text = result.toString()
        }

        return view
    }

}
