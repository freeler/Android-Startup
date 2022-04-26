package com.freeler.appstartup;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.freeler.appstartup.startup.core.Startup;
import com.freeler.appstartup.startup.core.StartupSortStore;
import com.freeler.appstartup.startup.core.TopologySort;
import com.freeler.appstartup.tasks.Task1;
import com.freeler.appstartup.tasks.Task2;
import com.freeler.appstartup.tasks.Task3;
import com.freeler.appstartup.tasks.Task4;
import com.freeler.appstartup.tasks.Task5;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TopologySortTest {
    private static final String TAG = "TopologySortTest";

    @Test
    public void testTopologySort() {
        List<Startup<?>> list = new ArrayList<>();
        list.add(new Task4());
        list.add(new Task5());
        list.add(new Task3());
        list.add(new Task2());
        list.add(new Task1());

        StartupSortStore startupSortStore = TopologySort.sort(list);
        List<Startup<?>> result = startupSortStore.getResult();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" \n======================================================\n");
        stringBuilder.append("  Task Graph:\n");
        for (Startup<?> startup : result) {
            stringBuilder.append("       ").append(startup.getClass().getName()).append("\n");
        }
        stringBuilder.append("======================================================");
        Log.e(TAG, stringBuilder.toString());
    }
}
