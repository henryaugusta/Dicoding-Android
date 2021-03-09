package com.firriezky.dicoding._4_FlexibleFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firriezky.dicoding.R
import com.firriezky.dicoding.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnDetailCategory.setOnClickListener {
            val mDetailCategoryFragment = DetailCategoryFragment()
            mDetailCategoryFragment.description="Namanya Syakir"
            mDetailCategoryFragment.childrenName="Syakir"
            val mFragmentManager  = fragmentManager

            binding.btnDetailCategory.setOnClickListener {
                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.frame_container,mDetailCategoryFragment)
                    addToBackStack(null)
                    commit()
                }
            }

//            moveToFragment(mDetailCategoryFragment)
        }

        binding.btnCategory.setOnClickListener {
            val mCategoryFragment = CategoryFragment()
            moveToFragment(mCategoryFragment)
        }
    }

    private fun moveToFragment(fragment: Fragment){
        val mFragmentManager  = fragmentManager
        mFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}