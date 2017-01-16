import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lilla on 15/01/17.
 */
public class Main {

    public static void main(String[] args) {
        ShipBay shipBay = new ShipBay();
        JFrame mainFrame = new JFrame("ShipBay");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(new Dimension(480, 320));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        JPanel panel11 = new JPanel();
        panel11.setLayout(new FlowLayout());
        JPanel panel12 = new JPanel();
        panel12.setLayout(new FlowLayout());
        JPanel panel13 = new JPanel();
        panel13.setLayout(new FlowLayout());
        panel1.add(panel11);
        panel1.add(panel13);
        panel1.add(panel12);
        JPanel panel111 = new JPanel();
        panel111.setLayout(new BoxLayout(panel111, BoxLayout.Y_AXIS));
        JPanel panel112 = new JPanel();
        panel112.setLayout(new BoxLayout(panel112, BoxLayout.Y_AXIS));
        panel11.add(panel111);
        panel11.add(panel112);
        JPanel panel1110 = new JPanel();
        panel1110.setLayout(new FlowLayout());
        JPanel panel1111 = new JPanel();
        panel1111.setLayout(new FlowLayout());
        JTextField passengerTextField = new JTextField("Passenger name");
        JTextField cargoItemTextField = new JTextField("Cargo item name");
        JTextField profitTextField = new JTextField("Profit");
        JTextField shipTextField = new JTextField("Ship");
        JRadioButton passengerMode = new JRadioButton();
        passengerMode.setSelected(true);
        JRadioButton cargoItemMode = new JRadioButton();
        passengerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passengerMode.isSelected()) {
                    cargoItemMode.setSelected(false);
                    if (!passengerTextField.getText().equals("Passenger name") || !cargoItemTextField.getText().equals("Cargo item name") || !profitTextField.getText().equals("Profit")){
                        shipTextField.setText("Please input a new ship name!");
                        System.out.println("change");
                    }
                }
                else  {
                    cargoItemMode.setSelected(true);
                    if (!passengerTextField.getText().equals("Passenger name") || !cargoItemTextField.getText().equals("Cargo item name") || !profitTextField.getText().equals("Profit")){
                        shipTextField.setText("Please input a new ship name!");
                    }
                    System.out.println("change");
                }
            }
        });
        cargoItemMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cargoItemMode.isSelected()){
                    passengerMode.setSelected(false);
                }
                else {
                    passengerMode.setSelected(true);
                }
            }
        });
        panel1110.add(passengerTextField);
        panel1110.add(passengerMode);
        panel1111.add(cargoItemTextField);
        panel1111.add(profitTextField);
        panel1111.add(cargoItemMode);
        panel111.add(panel1110);
        panel111.add(panel1111);
        panel111.add(shipTextField);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ship ship;
                if (!shipTextField.getText().equals("Please input a new ship name!")) {
                    if (shipBay.returnShip(shipTextField.getText()) == null) {
                        ship = shipBay.addShip(new Ship(shipTextField.getText()));
                    }
                    else {
                        ship = shipBay.returnShip(shipTextField.getText());
                    }
                    Compartment compartment = new Compartment(passengerMode.isSelected());
                    if (passengerMode.isSelected()) {
                        compartment.addCarriable(new Passenger(passengerTextField.getText()));
                    }
                    else {
                        compartment.addCarriable(new CargoItem(cargoItemTextField.getText(), Integer.parseInt(profitTextField.getText())));
                    }
                    if (ship == null) {
                        System.out.println("Ship is null");
                    }
                    ship.addCompartment(compartment);
                }
                else {
                    JOptionPane.showMessageDialog(mainFrame, "Please change the ship's name!");
                }

            }
        });
        panel112.add(addButton);
        JButton receiveButton = new JButton("Receive");
        receiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ship ship = shipBay.returnShip(shipTextField.getText());
                System.out.println(shipTextField.getText());
                if (ship == null) {
                    System.out.println("Ship is null");
                }
                shipBay.receiveShip(ship);
            }
        });
        JButton departButton = new JButton("Depart");
        departButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ship ship = shipBay.returnShip(shipTextField.getText());
                shipBay.departShip(ship);
            }
        });
        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ship ship = shipBay.returnShip(shipTextField.getText());
                if (shipBay.isShipInTheBay(ship)) {
                    checkButton.setBackground(Color.GREEN);
                }
                else {
                    checkButton.setBackground(Color.RED);
                }
            }
        });
        panel12.add(receiveButton);
        panel12.add(departButton);
        panel12.add(checkButton);
        JButton sortedByNameButton = new JButton("Ships sorted by name");
        sortedByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame sortedFrame = new JFrame("Ships sorted by name");
                sortedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                sortedFrame.setSize(new Dimension(480, 320));
                JLabel sortedText = new JLabel(shipBay.shipsSortedByName());
                sortedFrame.add(sortedText);
                sortedFrame.setContentPane(sortedText);
                sortedFrame.setVisible(true);
            }
        });
        JButton sortedByProfitButton = new JButton("Ships sorted by profit");
        sortedByProfitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame sortedFrame = new JFrame("Ships sorted by name");
                sortedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                sortedFrame.setSize(new Dimension(480, 320));
                JLabel sortedText = new JLabel(shipBay.shipsSortedByProfit());
                sortedFrame.add(sortedText);
                sortedFrame.setContentPane(sortedText);
                sortedFrame.setVisible(true);
            }
        });
        JButton summariesButton = new JButton("Summaries");
        summariesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame sortedFrame = new JFrame("Ships sorted by name");
                sortedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                sortedFrame.setSize(new Dimension(480, 320));
                JLabel sortedText = new JLabel(shipBay.summaries());
                sortedFrame.add(sortedText);
                sortedFrame.setContentPane(sortedText);
                sortedFrame.setVisible(true);
            }
        });
        panel13.add(sortedByNameButton);
        panel13.add(sortedByProfitButton);
        panel13.add(summariesButton);
        mainFrame.setContentPane(panel1);
        mainFrame.setVisible(true);
    }
}
