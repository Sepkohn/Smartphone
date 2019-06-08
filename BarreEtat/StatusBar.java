import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StatusBar implements Runnable {

    protected TimerThread timerThread;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new StatusBar());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setBounds(100, 200, 400, 200);
        //frame.setTitle("Status Bar Simulator");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        BarreEtat statusBar = new BarreEtat();
        JLabel leftLabel = new JLabel("Le Smartphone est allumé");
        statusBar.setLeftComponent(leftLabel);

        final JLabel dateLabel = new JLabel();
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        statusBar.addRightComponent(dateLabel);

        final JLabel timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        statusBar.addRightComponent(timeLabel);

        contentPane.add(statusBar, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        timerThread = new TimerThread(dateLabel, timeLabel);
        timerThread.start();

        frame.setVisible(true);
    }

    public void exitProcedure() {
        timerThread.setRunning(false);
        System.exit(0);
    }

    public class TimerThread extends Thread {

        protected boolean isRunning;

        protected JLabel dateLabel;
        protected JLabel timeLabel;

        protected SimpleDateFormat dateFormat =
                new SimpleDateFormat("EEE, d MMM yyyy");
        protected SimpleDateFormat timeFormat =
                new SimpleDateFormat("h:mm:ss a");

        public TimerThread(JLabel dateLabel, JLabel timeLabel) {
            this.dateLabel = dateLabel;
            this.timeLabel = timeLabel;
            this.isRunning = true;
        }

        @Override
        public void run() {
            while (isRunning) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Calendar currentCalendar = Calendar.getInstance();
                        Date currentTime = currentCalendar.getTime();
                        dateLabel.setText(dateFormat.format(currentTime));
                        timeLabel.setText(timeFormat.format(currentTime));
                    }
                });

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                }
            }
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }

    }

}