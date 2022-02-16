
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bindingnavigation.ItemsViewModel
import com.example.bindingnavigation.R

class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.titleView.text = ItemsViewModel.title

        // sets the text to the textview from our itemHolder class
        holder.subtitleView.text = ItemsViewModel.subtitle

//        holder.subtitleView.setOnClickListener {
//            val action = SpecifyAmountFragmentDirections.confirmationAction(holder.subtitleView.text)
//            it.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }


    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val titleView: TextView = itemView.findViewById(R.id.titleTextView)
        val subtitleView: TextView = itemView.findViewById(R.id.subtitleTextView)
    }
}