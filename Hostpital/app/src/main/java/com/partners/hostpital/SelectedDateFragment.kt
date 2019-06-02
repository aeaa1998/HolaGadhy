package com.partners.hostpital

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import com.partners.hostpital.helpers.Constants
import com.partners.hostpital.models.CalendarDatesResponse
import io.paperdb.Paper
import java.nio.channels.spi.SelectorProvider
import java.text.SimpleDateFormat


class Selected_date : Fragment() {

    var selectedDate: CalendarDatesResponse? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        selectedDate = Selected_dateArgs.fromBundle(requireArguments()).selectedDateFragment

        val v = inflater.inflate(R.layout.fragment_selected_date, container, false)
        val roleView = v.findViewById<ImageView>(R.id.role_view)
        val drawable = if (Paper.book().read<Int>(Constants.isDoctor) == 1){R.drawable.ic_patient}else{R.drawable.ic_doctor}
        roleView.setImageResource(drawable)
        val roleV = v.findViewById<TextView>(R.id.role_txt_selected_holder)
        val role = v.findViewById<TextView>(R.id.role_txt_selected)
        val reasonV = v.findViewById<TextView>(R.id.reason_txt_selected)
        val statusV = v.findViewById<TextView>(R.id.status_txt_selected)
        val dateV = v.findViewById<TextView>(R.id.date_txt_selected)
        val alwaysButton = v.findViewById<Button>(R.id.always_selected_date_button)
        val optionalButton = v.findViewById<Button>(R.id.optional_selected_button)

        roleV.text = if (Paper.book().read<Int>(Constants.isDoctor) == 1){getString(R.string.patient)}else{getString(R.string.doctor)}

        role.text = if (Paper.book().read<Int>(Constants.isDoctor) == 1){
            "${selectedDate?.patient?.firstName} ${selectedDate?.patient?.lastName}"
        }else{
            "${selectedDate?.doctor?.firstName} ${selectedDate?.doctor?.lastName}"
        }

        reasonV.text = "${selectedDate?.reason}"

        when(selectedDate?.status){
            0 ->  {
                statusV.text = getString(R.string.pending)
                statusV.setTextColor(getColor(requireContext(), R.color.pending))
                setOptionalButtonVisible(optionalButton)
                optionalButton.text = getString(R.string.button_reject)
                setAlwaysButton(alwaysButton, R.color.accept_green, R.string.button_accept)


            }
            1 ->  {
                statusV.text = getString(R.string.accepted)
                statusV.setTextColor(getColor(requireContext(), R.color.accept_green))
                setOptionalButtonInvisible(optionalButton)
                setAlwaysButton(alwaysButton, R.color.white, R.string.button_process_date)
                val action = Selected_dateDirections.actionSelectedDateToDoReportFragmentDate(selectedDate)
                setAlwaysButtonDirection(alwaysButton, action)

            }
            2 ->  {
                statusV.text = getString(R.string.rejected)
                statusV.setTextColor(getColor(requireContext(), R.color.reject_red))
                setOptionalButtonInvisible(optionalButton)
                setAlwaysButtonInvisible(alwaysButton)
            }
            3 ->  {
                statusV.text = getString(R.string.done)
                statusV.setTextColor(getColor(requireContext(), R.color.black))

                setOptionalButtonInvisible(optionalButton)
                setAlwaysButton(alwaysButton, R.color.white, R.string.button_check_report)



            }
        }

        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("dd.MM.yyyy")

        val output = formatter.format(parser.parse(selectedDate?.date.toString()))
        dateV.text= output



        // Inflate the layout for this fragment
        return v
    }
    fun setOptionalButtonVisible(optionalButton: Button){
        optionalButton.visibility = View.VISIBLE
        optionalButton.isClickable = true
        optionalButton.setBackgroundColor(getColor(requireContext(), R.color.reject_red))
    }
    fun setOptionalButtonInvisible(optionalButton: Button){
        optionalButton.visibility = View.GONE
        optionalButton.isClickable = false
    }

    fun setAlwaysButton(alwaysButton: Button, color: Int, string: Int){
        alwaysButton.visibility = View.VISIBLE
        alwaysButton.isClickable = true
        alwaysButton.setBackgroundColor(getColor(requireContext(), color))
        alwaysButton.text = getString(string)
    }
    fun setAlwaysButtonDirection(alwaysButton: Button, action: NavDirections){
        alwaysButton.setOnClickListener {
            NavHostFragment.findNavController(requireParentFragment()).navigate(action)
        }
    }
    fun setAlwaysButtonInvisible(alwaysButton: Button){
        alwaysButton.visibility = View.GONE
        alwaysButton.isClickable = false
    }



}
