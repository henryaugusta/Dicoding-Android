package com.firriezky.dicoding._4_FlexibleFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.firriezky.dicoding.R
import com.firriezky.dicoding.databinding.FragmentDialogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OptionDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class OptionDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding : FragmentDialogBinding

    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let {v->
            v.btnChoose.setOnClickListener {
                val checkedRadioButtonId = v.rgOptions.checkedRadioButtonId
                if (checkedRadioButtonId != -1) {
                    var coach: String? = null
                    when (checkedRadioButtonId) {
                        R.id.rb_saf -> coach =v.rbSaf.text.toString().trim()
                        R.id.rb_mou -> coach = v.rbMou.text.toString().trim()
                        R.id.rb_lvg -> coach = v.rbLvg.text.toString().trim()
                        R.id.rb_moyes -> coach = v.rbMoyes.text.toString().trim()
                    }
                    optionDialogListener?.onOptionChosen(coach)
                    dialog?.dismiss()
                }
            }
            v.btnClose.setOnClickListener {
                dialog?.cancel()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
        Saat attach maka set optionDialogListener dengan listener dari detailCategoryFragment
         */
        val fragment = parentFragment
        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()

        /*
        Saat detach maka set null pada optionDialogListener
         */
        this.optionDialogListener = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog, container, false)
        binding = FragmentDialogBinding.bind(view)
        // Inflate the layout for this fragment
        return view
    }


    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

}



