/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.zhanghai.android.fastscroll;

import android.view.MotionEvent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class SimpleViewHelper<T extends ViewGroup & SimpleFastScrollView>
        implements FastScroller.ViewHelper {

    @NonNull
    private final T mView;

    public SimpleViewHelper(@NonNull T view) {
        mView = view;
    }

    @Override
    public void addOnPreDrawListener(@NonNull Runnable onPreDraw) {
        mView.setOnPreDrawListener(onPreDraw);
    }

    @Override
    public void addOnScrollChangedListener(@NonNull Runnable onScrollChanged) {
        mView.setOnScrollChangedListener(onScrollChanged);
    }

    @Override
    public void addOnTouchEventListener(@NonNull Predicate<MotionEvent> onTouchEvent) {
        mView.setOnTouchEventListener(onTouchEvent);
    }

    @Override
    public int getScrollRange() {
        return mView.getScrollRange();
    }

    @Override
    public int getScrollOffset() {
        return mView.getScrollOffset();
    }

    @Override
    public void scrollTo(int offset) {
        mView.scrollTo(mView.getScrollX(), offset);
    }
}
