/*
 * Pomodoro Timer
 *
 * Copyright (c) 2010 Jiri Pospisil (jiripospisil.info)
 *
 * This software is licensed under the New BSD License. See
 * license.txt in the root directory of this software package
 * for more details.
 *
 */
package info.jiripospisil.pomodoro.actions;

import info.jiripospisil.pomodoro.ui.PomodoroPanel;
import info.jiripospisil.pomodoro.ui.PomodoroPanelBack;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.util.actions.Presenter;

/**
 *
 * @author Jiri Pospisil <mekishizufu@gmail.com>
 */
public class PomodoroAction implements ActionListener, Presenter.Toolbar {

    private final PomodoroPanelBack back;
    private final PomodoroPanel panel;

    public PomodoroAction() {
        panel = new PomodoroPanel();
        back = new PomodoroPanelBack(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public Component getToolbarPresenter() {
        return panel;
    }
}
