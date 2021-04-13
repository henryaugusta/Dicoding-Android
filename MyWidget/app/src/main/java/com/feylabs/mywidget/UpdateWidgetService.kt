package com.feylabs.mywidget

import android.app.job.JobParameters
import android.app.job.JobService
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.util.Log
import android.widget.RemoteViews

class UpdateWidgetService : JobService() {

    override fun onStopJob(params: JobParameters?): Boolean = false

    override fun onStartJob(params: JobParameters?): Boolean {
        val manager = AppWidgetManager.getInstance(this) as AppWidgetManager
        val view = RemoteViews(packageName,R.layout.random_name_widget)
        val theWidget = ComponentName(this,RandomNameWidget::class.java)
        val lastUpdate = "Random: "+NumberGenerator.generateNumber(100)

        view.setTextViewText(R.id.appwidget_text,lastUpdate)
        manager.updateAppWidget(theWidget,view)
        jobFinished(params,false)
        Log.d("job_update_widget","start")
        return true
    }


}