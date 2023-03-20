package com.khmaies.testandroidpartie2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khmaies.testandroidpartie2.R
import com.khmaies.testandroidpartie2.databinding.PersonneItemBinding
import com.khmaies.testandroidpartie2.model.Personne
import com.khmaies.testandroidpartie2.util.Helper.calculateAge

/**
 * Created by Khmaies Hassen on 20,mars,2023
 */
class PersonneAdapter :
    RecyclerView.Adapter<PersonneAdapter.PersonneViewHolder>() {
    private val data = ArrayList<Personne>()

    class PersonneViewHolder(
        private val binding: PersonneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Personne) {
            with(binding) {
                nameTextView.text =
                    binding.root.context.getString(R.string.full_name, data.nom, data.prenom)
                ageTextView.text = binding.root.context.getString(R.string.age, calculateAge(data.dateDeNaissance).toString()) // calculate age

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonneViewHolder {
        return PersonneViewHolder(
            PersonneItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(holder: PersonneViewHolder, position: Int) {
        holder.bind(data[position])
    }

    // below method is use to update our list of notes.
    fun updateList(newList: List<Personne>) {
        // on below line we are clearing
        // our notes array list
        data.clear()
        // on below line we are adding a
        // new list to our all notes list.
        data.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }

}