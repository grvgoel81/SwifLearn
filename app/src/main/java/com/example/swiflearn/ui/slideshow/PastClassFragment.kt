package com.example.swiflearn.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiflearn.R
import com.example.swiflearn.model.PastClassInfo
import kotlinx.android.synthetic.main.fragment_past_classes.*

class PastClassFragment : Fragment() {

    private lateinit var slideshowViewModel: PastClassViewModel
    private lateinit var pastClassAdapter: PastClassAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel = ViewModelProviders.of(this).get(PastClassViewModel::class.java)
        activity?.title = "Past Classes"
        return inflater.inflate(R.layout.fragment_past_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val languages = resources.getStringArray(R.array.Subjects)
        if (spinnerSubject != null) {
            val adapter = ArrayAdapter(
                requireActivity(),
                android.R.layout.simple_list_item_single_choice,
                languages
            )
            spinnerSubject.adapter = adapter

            spinnerSubject.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    when {
                        languages[position] == "Science" -> {
                            pastClassAdapter.bindItems(getPastClassesList(languages[position]))
                        }
                        languages[position] == "Maths" -> {
                            pastClassAdapter.bindItems(getPastClassesList(languages[position]))
                        }
                        else -> {
                            pastClassAdapter.bindItems(getPastClassesList(languages[position]))
                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }
        initAdapter()
        pastClassAdapter.bindItems(getPastClassesList("Science"))
    }

    private fun initAdapter() {
        pastClassAdapter = PastClassAdapter()
        rvPastClasses.apply {
            this.layoutManager = LinearLayoutManager(requireContext())
            adapter = pastClassAdapter
        }
    }

    private fun getPastClassesList(subject: String): ArrayList<PastClassInfo> {
        var list: ArrayList<PastClassInfo> = ArrayList()

        when (subject) {
            "Science" -> {

                list.add(
                    PastClassInfo(
                        "Science",
                        "Nutrition in Plants",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "Science",
                        "Nutrition in Plants",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "Science",
                        "Nutrition in Plants",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "Science",
                        "Nutrition in Plants",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
            }
            "Maths" -> {
                list.add(
                    PastClassInfo(
                        "Maths",
                        "Trignometry",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "Maths",
                        "Algebra",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "Maths",
                        "Trignometry",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "Maths",
                        "Trignometry",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )

            }
            else -> {
                list.add(
                    PastClassInfo(
                        "English",
                        "The Lost Man",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "English",
                        "Story of Lion",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "English",
                        "Nutrition in Plants",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
                list.add(
                    PastClassInfo(
                        "English",
                        "The Lost Man",
                        "24th Mar, 4PM - 5PM",
                        "Manisha Bhardwaj"
                    )
                )
            }
        }
        return list
    }

}