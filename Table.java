import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Table extends JFrame {
    private ArrayList<String[]> subjects = new ArrayList<>();

    public static void main(String[] args) {
        Table t1 = new Table();
        t1.run();
    }

    public void run() {
        boolean ready = true;
        Scanner input = new Scanner(System.in);

        while (ready) {
            System.out.print("Subject: ");
            String subject = input.nextLine();

            System.out.print("Time (00.00-00.00): ");
            String time = input.nextLine();

            System.out.print("Day(ex.mon): ");
            String day = input.nextLine();

            subjects.add(new String[] { subject, time, day });

            System.out.print("More subjects? (y/n): ");
            String check = input.nextLine();

            if (check.equalsIgnoreCase("n")) {
                ready = false;
            }
        }

        createTable();
        input.close();
    }

     public void createTable() {
        setTitle("Time Table");
        setSize(1400, 800);
        setBackground(Color.decode("#EBF5FB"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel frame = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.decode("#2874A6"));
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(5, 5, 1375, 750);
                g2d.drawLine(5, 50, 1380, 50);
                g2d.drawLine(118, 5, 118, 753);
                
                //lineday
                g2d.drawLine(5, 150, 1380, 150);
                g2d.drawLine(5, 250, 1380, 250);
                g2d.drawLine(5, 350, 1380, 350);
                g2d.drawLine(5, 450, 1380, 450);
                g2d.drawLine(5, 550, 1380, 550);
                g2d.drawLine(5, 650, 1380, 650);

                int rowHeight = 50;
                int columnWidth = 100;
                int x = 150, y = 55 ;

                g2d.setFont(new Font("Arial", Font.BOLD, 18));

                //linetimes
                x = 215;
                int increment = 97;

                for (int i = 0; i < 12; i++) {
                    int startX = (int) Math.round(x + (i * increment));
                    g2d.drawLine(startX, 5, startX, 50);
                }

                x = 150;
                y = 55;
                // Draw rows and subjects
                for (String[] subject : subjects) {
                    g2d.setColor(getColorByDay(subject[2]));
                    g2d.fillRect(x, y, columnWidth * 5, rowHeight);
                    g2d.setColor(Color.WHITE);
                    g2d.drawString(subject[0], x + 5, y + 30);
                    g2d.drawString(subject[1], x + 5, y + 20);
                    y += rowHeight;
                }
            }
        };

        // Define day labels
        JLabel mon = createDayLabel("MON", "#F9E79F", 12, 60);
        JLabel tue = createDayLabel("TUE", "#FADBD8", 12, 160);
        JLabel wed = createDayLabel("WED", "#D4EFDF", 12, 260);
        JLabel thu = createDayLabel("THU", "#EDBB99", 12, 360);
        JLabel fri = createDayLabel("FRI", "#AED6F1", 12, 460);
        JLabel sat = createDayLabel("SAT", "#D7BDE2", 12, 560);
        JLabel sun = createDayLabel("SUN", "#D98880", 12, 660);

        //timelabel
        JLabel daytime = createTimeLabel("DAY/TIME",10,7);
        JLabel eight = createTimeLabel("08.00",120,7);
        JLabel nine = createTimeLabel("09.00",210,7);
        JLabel ten = createTimeLabel("10.00",310,7);
        JLabel eleven = createTimeLabel("11.00",410,7);
        JLabel twelve = createTimeLabel("12.00",500,7);
        JLabel thirteen = createTimeLabel("13.00",600,7);
        JLabel fourteen = createTimeLabel("14.00",700,7);
        JLabel fifteen = createTimeLabel("15.00",795,7);
        JLabel sixteen = createTimeLabel("16.00",890,7);
        JLabel seventeen = createTimeLabel("17.00",990,7);
        JLabel eighteen = createTimeLabel("18.00",1085,7);
        JLabel nineteen = createTimeLabel("19.00",1185,7);
        JLabel twenty = createTimeLabel("20.00",1285,7);

        frame.add(daytime);
        frame.add(eight);
        frame.add(nine);
        frame.add(ten);
        frame.add(eleven);
        frame.add(twelve);
        frame.add(thirteen);
        frame.add(fourteen);
        frame.add(fifteen);
        frame.add(sixteen);
        frame.add(seventeen);
        frame.add(eighteen);
        frame.add(nineteen);
        frame.add(twenty);

        // Add labels to the frame
        frame.add(mon);
        frame.add(tue);
        frame.add(wed);
        frame.add(thu);
        frame.add(fri);
        frame.add(sat);
        frame.add(sun);

        frame.setLayout(null);
        frame.setBackground(Color.decode("#EBF5FB"));
        this.add(frame);
        setVisible(true);
    }

    

    private JLabel createDayLabel(String day, String colorHex, int x, int y) {
        JLabel label = new JLabel(day);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBackground(Color.decode(colorHex));
        label.setOpaque(true);
        label.setBounds(x, y, 100, 80);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JLabel createTimeLabel(String time, int x, int y) {
        JLabel label = new JLabel(time);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.BLACK);
        label.setBounds(x, y, 100, 40);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    

    private Color getColorByDay(String day) {
        switch (day.toUpperCase()) {
            case "MON":
                return Color.decode("#F9E79F");
            case "TUE":
                return Color.decode("#FADBD8");
            case "WED":
                return Color.decode("#D4EFDF");
            case "THU":
                return Color.decode("#EDBB99");
            case "FRI":
                return Color.decode("#AED6F1");
            case "SAT":
                return Color.decode("#D7BDE2");
            case "SUN":
                return Color.decode("#D98880");
            default:
                return Color.decode("#A6ACAF");
        }
    }
}