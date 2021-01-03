package moneyview.demo.adapter

import android.annotation.SuppressLint
import android.provider.Contacts
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import moneyview.demo.databinding.ItemPassengerBinding
import moneyview.demo.model.ResultsItem

class MoviesAdapter:PagingDataAdapter<ResultsItem, MoviesAdapter.PassengersViewHolder>(PassengersComparator) {

    override fun onBindViewHolder(holder: MoviesAdapter.PassengersViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bindPassenger(it)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.PassengersViewHolder {
        return PassengersViewHolder(
            ItemPassengerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class PassengersViewHolder(private val binding: ItemPassengerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindPassenger(item: ResultsItem) = with(binding) {
//            imageViewAirlinesLogo.loadImage(item.airline!!.logo!!)
  //          textViewHeadquarters.text = item.airline!!.headQuaters
            textViewNameWithTrips.text = "${item.title}, ${item.title} Trips"
        }
    }

    object PassengersComparator : DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem == newItem
        }
    }

}
