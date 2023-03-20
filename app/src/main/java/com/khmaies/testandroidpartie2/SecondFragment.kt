package com.khmaies.testandroidpartie2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.khmaies.testandroidpartie2.adapter.PersonneAdapter
import com.khmaies.testandroidpartie2.databinding.FragmentSecondBinding
import com.khmaies.testandroidpartie2.model.Personne
import com.khmaies.testandroidpartie2.viewmodel.PersonneViewModel
import com.khmaies.testandroidpartie2.viewmodel.ViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: PersonneViewModel by viewModels {
        ViewModelFactory.getInstance()
    }


    var list = mutableListOf<Personne>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.contactsRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PersonneAdapter()
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allPersonnes.observe(viewLifecycleOwner) { personnes ->
            personnes?.let {
                (binding.contactsRecyclerview.adapter as PersonneAdapter).updateList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}