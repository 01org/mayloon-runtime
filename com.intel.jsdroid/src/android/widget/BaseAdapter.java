/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/**
 * Common base class of common implementation for an {@link Adapter} that can be
 * used in both {@link ListView} (by implementing the specialized
 * {@link ListAdapter} interface} and {@link Spinner} (by implementing the
 * specialized {@link SpinnerAdapter} interface.
 */
public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
	public boolean hasStableIds() {
		return false;
	}

	public boolean areAllItemsEnabled() {
		return true;
	}

	public boolean isEnabled(int position) {
		return true;
	}

	public int getItemViewType(int position) {
		return 0;
	}

	public int getViewTypeCount() {
		return 1;
	}

    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

	public boolean isEmpty() {
		return getCount() == 0;
	}

	private final DataSetObservable mDataSetObservable = new DataSetObservable();

	public void registerDataSetObserver(DataSetObserver observer) {
		mDataSetObservable.registerObserver(observer);
	}
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
    }

	public void unregisterDataSetObserver(DataSetObserver observer) {
		mDataSetObservable.unregisterObserver(observer);
	}
	
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}