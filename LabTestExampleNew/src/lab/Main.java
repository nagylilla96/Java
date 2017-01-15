package lab;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static lab.Severity.HIGH;
import static lab.Severity.LOW;
import static lab.Severity.MEDIUM;

/**
 * Created by lilla on 15/01/17.
 */
public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        JFrame frame = new JFrame("Hospital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(480, 320));
        JPanel panel0 = new JPanel();
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel0.add(panel1);
        panel0.add(panel2);
        JTextField doctorNameField = new JTextField("Doctor name");
        JTextField patientNameField = new JTextField("Patient name");
        JTextField diseaseNameField = new JTextField("Disease name");
        JTextField doctorIDField = new JTextField("XXXXXXX");
        JTextField patientIDField = new JTextField("XXXXXXX");
        JTextField diseaseSeverityField = new JTextField("XXXXXX");
        JButton addDoctorButton = new JButton("Add doctor");
        addDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hospital.addDoctor(new Doctor(doctorNameField.getText(), Integer.parseInt(doctorIDField.getText())));
                } catch (InvalidDataException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton addPatientButton = new JButton("Add patient");
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hospital.addPatient(new Patient(patientNameField.getText(), Integer.parseInt(doctorIDField.getText())));
                } catch (InvalidDataException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton addDiseaseButton = new JButton("Add disease");
        addDiseaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Patient patient = null;
                if (hospital.returnPatient(patientNameField.getText()) == null) {
                    try {
                        hospital.addPatient(new Patient(patientNameField.getText(), Integer.parseInt(doctorIDField.getText())));
                    } catch (InvalidDataException e1) {
                        e1.printStackTrace();
                    }
                }else {
                    patient = hospital.returnPatient(patientNameField.getText());
                }

                Disease disease = new Disease(diseaseNameField.getText(), (Severity.valueOf(diseaseSeverityField.getText())));
                if (patient != null) {
                    patient.addDisease(disease);
                }
            }
        });
        JPanel panel11 = new JPanel();
        JPanel panel12 = new JPanel();
        JPanel panel13 = new JPanel();
        panel11.setLayout(new BoxLayout(panel11, BoxLayout.Y_AXIS));
        panel12.setLayout(new BoxLayout(panel12, BoxLayout.Y_AXIS));
        panel13.setLayout(new BoxLayout(panel13, BoxLayout.Y_AXIS));
        panel1.add(panel11);
        panel1.add(panel13);
        panel1.add(panel12);
        panel11.add(doctorNameField);
        panel11.add(patientNameField);
        panel11.add(diseaseNameField);
        panel13.add(doctorIDField);
        panel13.add(patientIDField);
        panel13.add(diseaseSeverityField);
        panel12.add(addDoctorButton);
        panel12.add(addPatientButton);
        panel12.add(addDiseaseButton);
        JButton listDoctorsButton = new JButton("Doctors");
        listDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame doctorFrame = new JFrame("Doctors");
                doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                doctorFrame.setSize(new Dimension(480, 320));
                JLabel doctorText = new JLabel("Doctors blablabla");
                doctorFrame.add(doctorText);
                doctorFrame.setContentPane(doctorText);
                doctorFrame.setVisible(true);
            }
        });
        JButton listPatientsButton = new JButton("Patients");
        JButton statisticsButton = new JButton("Statistics");
        JButton startHealingButton = new JButton("Start healing!");
        JPanel panel21 = new JPanel();
        JPanel panel22 = new JPanel();
        panel21.setLayout(new FlowLayout());
        panel22.setLayout(new FlowLayout());
        panel2.add(panel21);
        panel2.add(panel22);
        panel21.add(listDoctorsButton);
        panel21.add(listPatientsButton);
        panel21.add(statisticsButton);
        panel22.add(startHealingButton);
        frame.setContentPane(panel0);
        frame.setVisible(true);
        try {
            Doctor doctor = new Doctor("Nagy Lilla", 1234567);
            hospital.addDoctor(doctor);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        try {
            Doctor doctor = new Doctor("Vizer Arnold", 2345678);
            hospital.addDoctor(doctor);
            System.out.println("Doctor added");
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        try {
            Patient patient = new Patient("Acs David", 1234567);
            Disease disease = new Disease("hules", LOW);
            patient.addDisease(disease);
            Disease disease1 = new Disease("hasmenes", MEDIUM);
            patient.addDisease(disease1);
            hospital.addPatient(patient);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        try {
            Patient patient = new Patient("Albert Erika", 2345678);
            Disease disease = new Disease("gyomorgorcs", LOW);
            Disease disease1 = new Disease("fertozes", HIGH);
            patient.addDisease(disease);
            hospital.addPatient(patient);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        try {
            Patient patient = new Patient("Szabo Balint", 3456789);
            Disease disease = new Disease("fejfajas", LOW);
            Disease disease1 = new Disease("mandulagyulladas", HIGH);
            patient.addDisease(disease);
            patient.addDisease(disease1);
            patient.addDisease(new Disease("migren", MEDIUM));
            hospital.addPatient(patient);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        hospital.listDoctors();
        hospital.listPatients();
        hospital.startHealing();
        hospital.listDoctors();
        hospital.listPatients();
        hospital.statistics();
        hospital.startHealing();
        hospital.listDoctors();
        hospital.listPatients();
        hospital.statistics();
        hospital.startHealing();
        hospital.listDoctors();
        hospital.listPatients();
        hospital.statistics();
        hospital.startHealing();
        hospital.listDoctors();
        hospital.listPatients();
        hospital.statistics();
    }
}
