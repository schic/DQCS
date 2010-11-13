/**
 * eobjects.org DataCleaner
 * Copyright (C) 2010 eobjects.org
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
package org.eobjects.datacleaner.widgets.tooltip;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class DCPopupFactory extends PopupFactory {

	@Override
	public Popup getPopup(Component owner, Component contents, int x, int y) throws IllegalArgumentException {
		if (contents instanceof DCToolTip) {
			DCToolTip toolTip = (DCToolTip) contents;
			JComponent tooltipComponent = toolTip.getTooltipComponent();
			return super.getPopup(owner, tooltipComponent, x, y);
		}
		return super.getPopup(owner, contents, x, y);
	}
}
