package com.example.bindingnavigation

import CustomAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bindingnavigation.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // getting the recyclerview by its id
        val recyclerview = binding.recyclerview

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel( i.toString(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc tempor lectus suscipit eros finibus, sed posuere dui efficitur. Curabitur eget venenatis tortor, at faucibus tellus. Duis dictum ornare leo, at viverra elit maximus sed. Mauris eget massa luctus, laoreet ipsum at, luctus eros. Maecenas ex odio, feugiat eget scelerisque eget, mattis eu nulla. Donec nec quam ac dui consectetur imperdiet. Praesent rhoncus at neque vitae iaculis. Integer pretium, ante eget placerat vehicula, risus quam molestie eros, at euismod erat massa nec nisi. Aenean eget ipsum eu est ultricies tincidunt sit amet quis nibh. Etiam purus tellus, volutpat ac laoreet id, posuere vitae ex. Aenean sit amet neque malesuada, vestibulum ligula quis, elementum arcu."))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}