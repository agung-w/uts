package com.agung.uts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agung.uts.R
import com.agung.uts.databinding.HospitalCardBinding
import com.agung.uts.entity.Hospital

class HospitalSearchedDataAdapter(private val hospitals:ArrayList<Hospital>): RecyclerView.Adapter<HospitalSearchedDataAdapter.HospitalSearchViewHolder>() {
    inner class HospitalSearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding: HospitalCardBinding = HospitalCardBinding.bind(itemView)
        fun setData(hospital: Hospital){
            binding.hospitalNameTV.text=hospital.nama
            binding.textView3.text=hospital.alamat
            binding.textView4.text=hospital.telepon
        }
    }





    override fun getItemCount(): Int {
        return hospitals.size
    }

    override fun onBindViewHolder(holder: HospitalSearchViewHolder, position: Int) {
        holder.setData(hospitals[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalSearchViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.hospital_card,parent,false)
        return HospitalSearchViewHolder(view)
    }
}