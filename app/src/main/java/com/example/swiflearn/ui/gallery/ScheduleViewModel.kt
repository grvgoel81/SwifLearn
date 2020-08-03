package com.example.swiflearn.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScheduleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Upcoming Live Classes"
    }
    val text: LiveData<String> = _text
}