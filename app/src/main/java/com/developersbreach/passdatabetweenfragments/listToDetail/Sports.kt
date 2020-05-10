package com.developersbreach.passdatabetweenfragments.listToDetail

import android.content.Context
import android.os.Parcelable
import com.developersbreach.passdatabetweenfragments.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sports(val name: String, val year: String) : Parcelable {

    companion object {
        fun sportsList(context: Context): List<Sports> {
            return listOf(
                Sports(
                    context.getString(R.string.title_basketball),
                    context.getString(R.string.subtitle_basketball)
                ),
                Sports(
                    context.getString(R.string.title_volleyball),
                    context.getString(R.string.subtitle_volleyball)
                ),
                Sports(
                    context.getString(R.string.title_esports),
                    context.getString(R.string.subtitle_esports)
                ),
                Sports(
                    context.getString(R.string.title_kabbadi),
                    context.getString(R.string.subtitle_kabbadi)
                ),
                Sports(
                    context.getString(R.string.title_baseball),
                    context.getString(R.string.subtitle_baseball)
                ),
                Sports(
                    context.getString(R.string.title_mma), context.getString(R.string.subtitle_mma)
                ),
                Sports(
                    context.getString(R.string.title_soccer),
                    context.getString(R.string.subtitle_soccer)
                ),
                Sports(
                    context.getString(R.string.title_handball),
                    context.getString(R.string.subtitle_handball)
                ),
                Sports(
                    context.getString(R.string.title_tennis),
                    context.getString(R.string.subtitle_tennis)
                ),
                Sports(
                    context.getString(R.string.title_rugby),
                    context.getString(R.string.subtitle_rugby)
                ),
                Sports(
                    context.getString(R.string.title_cricket),
                    context.getString(R.string.subtitle_cricket)
                ),
                Sports(
                    context.getString(R.string.title_hockey),
                    context.getString(R.string.subtitle_hockey)
                )
            )
        }
    }
}