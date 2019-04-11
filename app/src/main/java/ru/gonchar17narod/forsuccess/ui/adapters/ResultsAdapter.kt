package ru.gonchar17narod.forsuccess.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import ru.gonchar17narod.forsuccess.R
import ru.gonchar17narod.forsuccess.mvp.models.AppleResults.Result
import ru.gonchar17narod.forsuccess.ui.activities.WebViewActivity

class ResultsAdapter(val resultsList: List<Result>): RecyclerView.Adapter<ResultsAdapter.ResultViewHolder>() {


    class ResultViewHolder( val itemResultView: View): RecyclerView.ViewHolder(itemResultView) {

        val textName: TextView
        val textPrice: TextView
        val textDate: TextView
        val textVersion: TextView
        val imageIcon: ImageView

        init {
            this.textName = itemResultView.findViewById(R.id.textName)
            this.textPrice = itemResultView.findViewById(R.id.textPrice)
            this.textDate = itemResultView.findViewById(R.id.textDate)
            this.textVersion = itemResultView.findViewById(R.id.textVersion)
            this.imageIcon = itemResultView.findViewById(R.id.imageIcon)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ResultViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.result_item, p0, false)
        return ResultViewHolder(v)
    }

    override fun onBindViewHolder(p0: ResultViewHolder, p1: Int) {

        val result = resultsList.get(p1)

        p0.textName.setText(result.trackName)
        p0.textPrice.setText(result.formattedPrice)
        p0.textDate.setText(result.currentVersionReleaseDate)
        p0.textVersion.setText(result.version)

        Picasso.get().load(result.artworkUrl100).into(p0.imageIcon)

        p0.itemResultView.setOnClickListener {
            val intent = Intent(p0.itemResultView.context, WebViewActivity::class.java)
            intent.putExtra("url", result.trackViewUrl)
            p0.itemResultView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return resultsList.size
    }
}