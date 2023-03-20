package com.khmaies.testandroidpartie2

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.khmaies.testandroidpartie2.databinding.FragmentFirstBinding
import com.khmaies.testandroidpartie2.model.Personne
import com.khmaies.testandroidpartie2.util.Helper
import com.khmaies.testandroidpartie2.viewmodel.PersonneViewModel
import com.khmaies.testandroidpartie2.viewmodel.ViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: PersonneViewModel by viewModels {
        ViewModelFactory.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textviewNom
        binding.buttonSubmit.setOnClickListener {
            val personne = Personne(
                nom = binding.textviewNom.text.toString(),
                prenom = binding.textviewPrenom.text.toString(),
                dateDeNaissance = "${binding.textviewBirthdate.dayOfMonth}/${binding.textviewBirthdate.month}/${binding.textviewBirthdate.year}"
            )
            Log.e("monster","date ${personne.dateDeNaissance}")
            if(Helper.calculateAge(personne.dateDeNaissance) < 150) {
                viewModel.insert(personne)
            } else {
                Snackbar.make(view, "Age should be less that 150 years", Snackbar.LENGTH_LONG)
                    .show()
            }
        }

        binding.buttonView.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}