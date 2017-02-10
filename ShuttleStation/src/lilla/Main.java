package lilla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lilla on 17/01/17.
 */
public class Main {

    public static void main(String[] args) {
        Station station = new Station();

        JFrame frame = new JFrame("Shuttle Station");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(480, 320));
        JPanel panel0 = new JPanel();
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
        frame.setContentPane(panel0);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JPanel panel3 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel0.add(panel1);
        panel0.add(panel2);
        panel0.add(panel3);
        station.addShuttle(new Shuttle("Shuttle1", Status.docked, 50));
        station.addShuttle(new Shuttle("Shuttle2", Status.docked, 36));
        station.addShuttle(new Shuttle("Shuttle3", Status.docked, 70));
        station.addShuttle(new Shuttle("Shuttle4", Status.docked, 32));
        station.addShuttle(new Shuttle("Shuttle5", Status.docked, 24));
        station.addShuttle(new Shuttle("Shuttle6", Status.docked, 76));
        station.addShuttle(new Shuttle("Shuttle7", Status.docked, 13));
        station.addShuttle(new Shuttle("Shuttle8", Status.docked, 22));
        station.addShuttle(new Shuttle("Shuttle9", Status.docked, 77));
        station.addShuttle(new Shuttle("Shuttle10", Status.docked, 50));

        JButton summary = new JButton("Summary");
        JButton byProfit = new JButton("Sort by profit");
        JComboBox shuttlesList = new JComboBox(station.getShuttles());
        String[] operation = {"Shuttle", "Depart", "Arrive", "Dock", "List passengers"};
        JComboBox operationsList = new JComboBox(operation);
        JButton doOperation = new JButton("Do operation");
        class Action implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == summary) {
                    JFrame summaryFrame = new JFrame("Summary");
                    summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    summaryFrame.setSize(new Dimension(480, 320));
                    JLabel summaryText = new JLabel(station.createSummary()); //TODO
                    summaryFrame.add(summaryText);
                    summaryFrame.setContentPane(summaryText);
                    summaryFrame.setVisible(true);
                }
                if (e.getSource() == byProfit) {
                    JFrame byProfitFrame = new JFrame("By Profit");
                    byProfitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    byProfitFrame.setSize(new Dimension(480, 320));
                    JLabel byProfitText = new JLabel(station.sortedByProfit()); //TODO
                    byProfitFrame.add(byProfitText);
                    byProfitFrame.setContentPane(byProfitText);
                    byProfitFrame.setVisible(true);
                }
                if (e.getSource() == doOperation) {
                    Shuttle shuttle = station.getShuttle((String)shuttlesList.getSelectedItem());
                    switch ((String)operationsList.getSelectedItem()) {
                        case "Shuttle":
                            JFrame shuttleFrame = new JFrame("Shuttle data");
                            shuttleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            shuttleFrame.setSize(new Dimension(480, 320));
                            float number;
                            if (shuttle.returnProfit() == null) {
                                number = 0;
                            }
                            else {
                                number = shuttle.returnProfit();
                            }
                            JLabel shuttleText = new JLabel(shuttle.getName() + " " + number + " " + shuttle.getStatus()); //TODO
                            shuttleFrame.add(shuttleText);
                            shuttleFrame.setContentPane(shuttleText);
                            shuttleFrame.setVisible(true);
                            break;
                        case "Depart":
                            station.departShuttle(shuttle);
                            break;
                        case "Arrive":
                            station.arriveShuttle(shuttle);
                            break;
                        case "Dock":
                            station.dockShuttle(shuttle);
                            break;
                        case "List passengers":
                            JFrame passengersFrame = new JFrame("All passengers");
                            passengersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            passengersFrame.setSize(new Dimension(480, 320));
                            JLabel passengerText = new JLabel(shuttle.listPassengers()); //TODO
                            passengersFrame.add(passengerText);
                            passengersFrame.setContentPane(passengerText);
                            passengersFrame.setVisible(true);
                            break;
                        default:
                            break;
                    }

                }
            }
        }
        Action action = new Action();

        summary.addActionListener(action);

        byProfit.addActionListener(action);
        panel1.add(summary);
        panel1.add(byProfit);

        shuttlesList.addActionListener(action);


        shuttlesList.addActionListener(action);
        panel2.add(shuttlesList);
        panel2.add(operationsList);
        doOperation.addActionListener(action);
        panel3.add(doOperation);
        frame.setVisible(true);

    }

}
