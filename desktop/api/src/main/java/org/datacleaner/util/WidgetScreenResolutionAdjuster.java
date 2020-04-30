/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.util;

import java.awt.GraphicsEnvironment;
import java.awt.Image;

/**
 * Class responsible for adjusting/scaling widgets according to the screen resolution. This is to provide a good user
 * experience for users with high DPI screens - ensuring that what is normally just 1 pixel may take up more when a
 * pixel is extraordinarily small on the physical screen.
 * 负责根据屏幕分辨率调整/缩放窗口小部件的类。
 * 这将为具有高DPI屏幕的用户提供良好的用户体验-确保当物理屏幕上的像素异常小时，
 * 通常只有1个像素的像素会占用更多的像素。
 */
public class WidgetScreenResolutionAdjuster {

    private static final float MAX_ADJUSTMENT = 3f;

    private static final WidgetScreenResolutionAdjuster INSTANCE = new WidgetScreenResolutionAdjuster();

    public static WidgetScreenResolutionAdjuster get() {
        return INSTANCE;
    }

    // threshold in screen width above which we'll start scaling the UI
    private final int highDpiThreshold;
    private final int width;

    private WidgetScreenResolutionAdjuster() {
        highDpiThreshold = SystemProperties.getInt("datacleaner.highdpi.threshold", 1600);
        if (GraphicsEnvironment.isHeadless()) {
            width = highDpiThreshold;
        } else {
            final GraphicsEnvironment graphicsEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            width = (int) graphicsEnv.getMaximumWindowBounds().getWidth();
        }
    }

    public int adjust(int size) {
        return (int) (size * getSizeAdjustment());
    }

    public float adjust(float size) {
        return size * getSizeAdjustment();
    }

    public double adjust(double size) {
        return size * getSizeAdjustment();
    }

    public float getSizeAdjustment() {

        if (width <= highDpiThreshold) {
            return 1;
        }

        return Math.min(MAX_ADJUSTMENT, 1.0f * width / highDpiThreshold);
    }

    public Image scale(Image image) {
        if (image == null || getSizeAdjustment() == 1f) {
            return image;
        }
        final int w = image.getWidth(null);
        final int h = image.getHeight(null);

        return image.getScaledInstance(adjust(w), adjust(h), Image.SCALE_SMOOTH);
    }
}
