package com.developersbreach.passdatabetweenfragments.listToDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener

import com.developersbreach.passdatabetweenfragments.R
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    companion object {

        const val SPORTS_DATA_REQUEST_KEY: String = "SPORTS_DATA_REQUEST_KEY_VALUE"
        const val SPORTS_DATA_BUNDLE_KEY: String = "SPORTS_DATA_BUNDLE_KEY_VALUE"

        fun newInstance(): DetailFragment {
            return DetailFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)
        val detailNameTextView: TextView = view.findViewById(R.id.detail_fragment_name_text_view)
        val detailYearTextView: TextView = view.findViewById(R.id.detail_fragment_year_text_view)

        setFragmentResultListener(SPORTS_DATA_REQUEST_KEY) { resultKey, bundle ->
            val data: Sports? = bundle.getParcelable(SPORTS_DATA_BUNDLE_KEY)
            detailNameTextView.text = data?.name
            detailYearTextView.text = data?.year
        }

        return view
    }

}
