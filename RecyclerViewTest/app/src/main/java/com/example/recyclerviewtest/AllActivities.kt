package com.example.recyclerviewtest

import android.app.Activity

object AllActivities {
    var activities = ArrayList<Activity>()
            fun addActivity(a: Activity){
                activities.add(a)
            }
    fun removeActivity(b: Activity){
        activities.remove(b)
    }
    fun finishAll(){
        for (ac in activities){
            if(!ac.isFinishing){
                ac.finish()
            }
        }
        activities.clear()
    }
}