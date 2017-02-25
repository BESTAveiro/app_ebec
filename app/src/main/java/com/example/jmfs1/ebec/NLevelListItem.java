package com.example.jmfs1.ebec;

import android.view.View;

/**
 * Created by miguel on 21-12-2016.
 */

public interface NLevelListItem {
    public boolean isExpanded();
    public void toggle();
    public NLevelListItem getParent();
    public View getView();
}
