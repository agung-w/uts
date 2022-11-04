package com.agung.uts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agung.uts.R
import com.agung.uts.databinding.HospitalCardBinding
import com.agung.uts.entity.Hospital

class HospitalDataAdapter(private val hospitals:ArrayList<Hospital>): RecyclerView.Adapter<HospitalDataAdapter.HospitalViewHolder>() {
    private lateinit var hospitalDataListener:HospitalDataListener
    inner class HospitalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding: HospitalCardBinding=HospitalCardBinding.bind(itemView)
        fun setData(hospital: Hospital){
            binding.hospitalNameTV.text=hospital.nama
            binding.textView3.text=hospital.alamat
            binding.textView4.text=hospital.telepon
        }
    }
    interface HospitalDataListener{
        fun cardClicked(hospital:Hospital)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.hospital_card,parent,false)
        return HospitalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.setData(hospitals[position])
        holder.itemView.setOnClickListener{
            hospitalDataListener.cardClicked(hospitals[position])
        }
    }

    override fun getItemCount(): Int {
        return hospitals.size
    }

    fun setHospitalDataListener(hospitalDataListener: HospitalDataListener){
        this.hospitalDataListener=hospitalDataListener
    }
}