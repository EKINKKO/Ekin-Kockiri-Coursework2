import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop {
    private ArrayList<Gadget> gadgets;
    private JFrame frame;
    private JTextField modelField, priceField, sizeField, weightField, creditField, memoryField, phoneNumberField, durationField, downloadSizeField, displayNumberField;
    private JTextArea outputArea;

    public GadgetShop() {
        gadgets = new ArrayList<>();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 4, 5, 5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.setContentPane(contentPane);

        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField();
        contentPane.add(modelLabel);
        contentPane.add(modelField);

        JLabel priceLabel = new JLabel("Price (£):");
        priceField = new JTextField();
        contentPane.add(priceLabel);
        contentPane.add(priceField);

        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JTextField();
        contentPane.add(sizeLabel);
        contentPane.add(sizeField);

        JLabel weightLabel = new JLabel("Weight (g):");
        weightField = new JTextField();
        contentPane.add(weightLabel);
        contentPane.add(weightField);

        JLabel creditLabel = new JLabel("Initial Credit (for mobile):");
        creditField = new JTextField();
        contentPane.add(creditLabel);
        contentPane.add(creditField);

        JLabel memoryLabel = new JLabel("Initial Memory (for MP3):");
        memoryField = new JTextField();
        contentPane.add(memoryLabel);
        contentPane.add(memoryField);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();
        contentPane.add(phoneNumberLabel);
        contentPane.add(phoneNumberField);

        JLabel durationLabel = new JLabel("Duration (minutes):");
        durationField = new JTextField();
        contentPane.add(durationLabel);
        contentPane.add(durationField);

        JLabel downloadSizeLabel = new JLabel("Download Size (MB):");
        downloadSizeField = new JTextField();
        contentPane.add(downloadSizeLabel);
        contentPane.add(downloadSizeField);

        JLabel displayNumberLabel = new JLabel("Display Number:");
        displayNumberField = new JTextField();
        contentPane.add(displayNumberLabel);
        contentPane.add(displayNumberField);

        JButton addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMobile();
            }
        });
        contentPane.add(addMobileButton);

        JButton addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMP3();
            }
        });
        contentPane.add(addMP3Button);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        contentPane.add(clearButton);

        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });
        contentPane.add(displayAllButton);

        JButton makeCallButton = new JButton("Make A Call");
        makeCallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeCall();
            }
        });
        contentPane.add(makeCallButton);

        JButton downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
            }
        });
        contentPane.add(downloadMusicButton);

        frame.pack();
        frame.setVisible(true);
    }

    private void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addMobile() {
        String model = modelField.getText();
        String priceText = priceField.getText();
        String size = sizeField.getText();
        String weightText = weightField.getText();
        String creditText = creditField.getText();

        if (model.isEmpty() || priceText.isEmpty() || size.isEmpty() || weightText.isEmpty() || creditText.isEmpty()) {
            outputArea.append("Error: Please fill in all fields.\n");
            return;
        }

        double price;
        int weight, credit;

        try {
            price = Double.parseDouble(priceText);
            weight = Integer.parseInt(weightText);
            credit = Integer.parseInt(creditText);
        } catch (NumberFormatException e) {
            outputArea.append("Error: Price, weight, and credit must be numeric values.\n");
            return;
        }

        gadgets.add(new Mobile(model, price, weight, size, credit));
        clearFields();
        outputArea.append("Mobile added: " + model + "\n");
    }

    private void addMP3() {
        String model = modelField.getText();
        String priceText = priceField.getText();
        String size = sizeField.getText();
        String weightText = weightField.getText();
        String memoryText = memoryField.getText();

        if (model.isEmpty() || priceText.isEmpty() || size.isEmpty() || weightText.isEmpty() || memoryText.isEmpty()) {
            outputArea.append("Error: Please fill in all fields.\n");
            return;
        }

        double price;
        int weight, memory;

        try {
            price = Double.parseDouble(priceText);
            weight = Integer.parseInt(weightText);
            memory = Integer.parseInt(memoryText);
        } catch (NumberFormatException e) {
            outputArea.append("Error: Price, weight, and memory must be numeric values.\n");
            return;
        }

        gadgets.add(new MP3(model, price, weight, size, memory));
        clearFields();
        outputArea.append("MP3 added: " + model + "\n");
    }

    private void makeCall() {
        String phoneNumber = phoneNumberField.getText();
        String durationText = durationField.getText();
        String displayNumberText = displayNumberField.getText();

        if (phoneNumber.isEmpty() || durationText.isEmpty() || displayNumberText.isEmpty()) {
            outputArea.append("Error: Please fill in all fields.\n");
            return;
        }

        int duration, displayNumber;

        try {
            duration = Integer.parseInt(durationText);
            displayNumber = Integer.parseInt(displayNumberText);
        } catch (NumberFormatException e) {
            outputArea.append("Error: Duration and display number must be numeric values.\n");
            return;
        }

        if (displayNumber < 0 || displayNumber >= gadgets.size()) {
            outputArea.append("Error: Invalid display number.\n");
            return;
        }

        if (!(gadgets.get(displayNumber) instanceof Mobile)) {
            outputArea.append("Error: The selected gadget is not a mobile.\n");
            return;
        }

        Mobile mobile = (Mobile) gadgets.get(displayNumber);
        mobile.makeCall(phoneNumber, duration);
    }

    private void downloadMusic() {
        String downloadSizeText = downloadSizeField.getText();
        String displayNumberText = displayNumberField.getText();

        if (downloadSizeText.isEmpty() || displayNumberText.isEmpty()) {
            outputArea.append("Error: Please fill in all fields.\n");
            return;
        }

        int downloadSize, displayNumber;

        try {
            downloadSize = Integer.parseInt(downloadSizeText);
            displayNumber = Integer.parseInt(displayNumberText);
        } catch (NumberFormatException e) {
            outputArea.append("Error: Download size and display number must be numeric values.\n");
            return;
        }

        if (displayNumber < 0 || displayNumber >= gadgets.size()) {
            outputArea.append("Error: Invalid display number.\n");
            return;
        }

        if (!(gadgets.get(displayNumber) instanceof MP3)) {
            outputArea.append("Error: The selected gadget is not an MP3 player.\n");
            return;
        }

        MP3 mp3 = (MP3) gadgets.get(displayNumber);
        mp3.downloadMusic(downloadSize);
    }

    private void displayAll() {
        if (gadgets.isEmpty()) {
            outputArea.append("No gadgets to display.\n");
            return;
        }

        outputArea.setText("");

        for (int i = 0; i < gadgets.size(); i++) {
            Gadget gadget = gadgets.get(i);
            outputArea.append("Gadget " + i + ":\n");
            gadget.display();
            outputArea.append("\n");
        }
    }

    private void clearFields() {
        modelField.setText("");
        displayNumberField.setText("");
        priceField.setText("");
        sizeField.setText("");
        weightField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GadgetShop();
            }
        });
    }
}
