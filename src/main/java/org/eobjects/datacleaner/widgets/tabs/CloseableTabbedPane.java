package org.eobjects.datacleaner.widgets.tabs;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import org.eobjects.datacleaner.util.WidgetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a slightly rewritten/modified version of swingutil's
 * ClosableTabbedPane
 */
public final class CloseableTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = -411551524171347329L;
	private static Logger _logger = LoggerFactory.getLogger(CloseableTabbedPane.class);

	private final List<TabCloseListener> _closeListener = new LinkedList<TabCloseListener>();
	private final List<Integer> _unclosables = new LinkedList<Integer>();
	private final List<Integer> _separators = new LinkedList<Integer>();

	/**
	 * Create a tabbed pane
	 */
	public CloseableTabbedPane() {
		super(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		setUI(new CloseableTabbedPaneUI(this));
		setBorder(new LineBorder(WidgetUtils.BG_COLOR_DARK, 4));
		setForeground(WidgetUtils.BG_COLOR_BRIGHTEST);
		setBackground(WidgetUtils.BG_COLOR_DARK);
		setOpaque(true);
	}

	/**
	 * Tyically, the last tab open is not closable. So, call this method with a
	 * tab number and that tab will not contain a close icon. If you monitor
	 * with a {@link TabCloseListener}, you can use {@link #getTabCount()} and
	 * when it is 1, you can call {@link #setUncloseableTab(int)}(0) to make the
	 * last tab unclosable.
	 * 
	 * @return
	 * 
	 * @see #setCloseableTab(int);
	 */
	public CloseableTabbedPane setUnclosableTab(int val) {
		if (!_unclosables.contains(val)) {
			_unclosables.add(val);
		}
		return this;
	}

	public void addSeparator() {
		synchronized (this) {
			int tabCountBefore = getTabCount();
			addTab("SEPARATOR", new JLabel());
			_separators.add(tabCountBefore);
		}
	}

	/**
	 * Use this method to reverse the actions of {@link #setUnclosableTab(int)}
	 */
	public void setClosableTab(int val) {
		_unclosables.remove(val);
	}

	@SuppressWarnings("unchecked")
	public <E extends Component> List<E> getTabsOfClass(Class<E> clazz) {
		List<E> list = new ArrayList<E>();
		Component[] components = getComponents();
		for (Component component : components) {
			if (component instanceof JScrollPane) {
				component = ((JScrollPane) component).getViewport().getComponent(0);
			}
			if (clazz.isAssignableFrom(component.getClass())) {
				list.add((E) component);
			}
		}
		return list;
	}

	/**
	 * Add a tab close listener. On close events, the listener is responsible
	 * for deleting the tab or otherwise reacting to the event.
	 */
	public void addTabCloseListener(TabCloseListener lis) {
		_closeListener.add(lis);
	}

	/** Remove a tab close listener */
	public void removeTabCloseListener(TabCloseListener lis) {
		_closeListener.remove(lis);
	}

	public void closeTab(int tab) {
		if (_closeListener.size() == 0) {
			return;
		}

		TabCloseEvent ev = new TabCloseEvent(this, tab);
		for (TabCloseListener l : _closeListener) {
			try {
				l.tabClosing(ev);
			} catch (Exception ex) {
				_logger.error(ex.toString(), ex);
			}
		}

		remove(tab);
	}

	public void closeAllTabs() {
		for (int i = getTabCount() - 1; i >= 0; i--) {
			closeTab(i);
		}
		removeAll();
	}

	protected List<Integer> getUnclosables() {
		return _unclosables;
	}

	protected List<Integer> getSeparators() {
		return _separators;
	}

	@Override
	public void removeNotify() {
		super.removeNotify();
		closeAllTabs();
	}
	
	@Override
	public Color getForegroundAt(int index) {
		if (getSelectedIndex() == index) {
			return WidgetUtils.BG_COLOR_DARKEST;
		}
		return super.getForegroundAt(index);
	}
}