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
package info.jiripospisil.pomodoro.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 *
 * @author Jiri Pospisil <mekishizufu@gmail.com>
 */
public class PomodoroPanelBack {

    private static final int TIME_LIMIT = 60 * 25;
    private final PomodoroPanel panel;
    private final Timer timer;
    private boolean isRunning;
    private int timeLeft;

    public PomodoroPanelBack(PomodoroPanel panel) {
        this.panel = panel;
        this.panel.addButtonListener(new ClickListener());

        this.timer = new Timer(0, new TickListener());
        this.timer.setDelay(1000);

        this.isRunning = false;
        this.timeLeft = TIME_LIMIT;

        updateButtonTime();
    }

    class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isRunning) {
                stopCountdown();
            } else {
                startCountdown();
            }
        }
    }

    class TickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            timeLeft -= 1;

            updateButtonTime();

            if (timeLeft == 0) {
                showNotification();
                stopCountdown();
            }
        }
    }

    private void startCountdown() {
        isRunning = true;

        resetTime();
        updateButtonTime();

        timer.start();
    }

    private void stopCountdown() {
        isRunning = false;

        resetTime();
        updateButtonTime();

        timer.stop();
    }

    private void resetTime() {
        timeLeft = TIME_LIMIT;
    }

    private void updateButtonTime() {
        String time = String.format("%02d:%02d", timeLeft / 60, timeLeft % 60);
        panel.getButton().setText(time);
    }

    private void showNotification() {
        String message = NbBundle.getMessage(PomodoroPanelBack.class,
                "PomodoroPanelBack.notification.text");
        String title = NbBundle.getMessage(PomodoroPanelBack.class,
                "PomodoroPanelBack.notification.title");

        JOptionPane.showMessageDialog(null,
                message, title, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(ImageUtilities.loadImage(
                "info/jiripospisil/pomodoro/resources/icon.gif")));
    }
}
