import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserRegistrationForm {

    public static void main(String[] args) {
        JFrame frame = new JFrame("User Registration");
        frame.setSize(450, 600);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Name Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(new JLabel("* Name :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JTextField nameField = new JTextField(15);
        frame.add(nameField, gbc);

        // Number Label (added as required field)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(new JLabel("* Number :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JTextField numberField = new JTextField(15);
        frame.add(numberField, gbc);

        // Address Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(new JLabel("Address :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JTextField addressField = new JTextField(15);
        frame.add(addressField, gbc);

        // Gender Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(new JLabel("Gender :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        frame.add(genderPanel, gbc);

        // Country Label
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(new JLabel("Country :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        String[] countries = {"Select One", "Nepal", "India", "China"};
        JComboBox<String> countryCombo = new JComboBox<>(countries);
        frame.add(countryCombo, gbc);

        // Hobbies
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(new JLabel("Hobbies :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        JCheckBox coding = new JCheckBox("Coding");
        frame.add(coding, gbc);

        gbc.gridy = 6;
        JCheckBox watchingMovies = new JCheckBox("Watching Movies");
        frame.add(watchingMovies, gbc);

        gbc.gridy = 7;
        JCheckBox travelling = new JCheckBox("Travelling");
        frame.add(travelling, gbc);

        // Submit Button
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        JButton submitButton = new JButton("Submit");
        frame.add(submitButton, gbc);

        // JTextArea for displaying output
        JTextArea displayArea = new JTextArea(8, 30);
        displayArea.setEditable(false);  // Set to non-editable
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setBorder(null);

        // Add JTextArea to frame using scroll pane
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(null);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(scrollPane, gbc);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String number = numberField.getText();

                if (name.isEmpty() || number.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name and Number are required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Collect other form data
                    String address = addressField.getText();
                    String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Not specified";
                    String country = (String) countryCombo.getSelectedItem();
                    assert country != null;
                    if (country.equals("Select One")) {
                        country = "Not Selected";
                    }

                    ArrayList<String> hobbiesList = new ArrayList<>();
                    if (coding.isSelected()) hobbiesList.add("Coding");
                    if (watchingMovies.isSelected()) hobbiesList.add("Watching Movies");
                    if (travelling.isSelected()) hobbiesList.add("Travelling");

                    String hobbies = hobbiesList.isEmpty() ? "None" : String.join(", ", hobbiesList);

                    String formattedOutput = String.format(
                                    "\n"+
                                    " Name    :  %s%n" +
                                    " Address :  %s%n" +
                                    " Gender  :  %s%n" +
                                    " Country :  %s%n" +
                                    " Number  :  %s%n" +
                                    " Hobbies :  %s",
                            name, address, gender, country, number, hobbies
                    );

                    displayArea.setText(formattedOutput);
                }
            }
        });

        frame.setVisible(true);
    }
}
