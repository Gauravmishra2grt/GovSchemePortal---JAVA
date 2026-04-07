
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class GovSchemePortal extends JFrame {

    private List<Scheme> allSchemes;
    private JPanel cardsPanel;
    private JTextField searchField;
    private JComboBox<String> categoryCombo;

    public GovSchemePortal() {
        // UI Setup
        setTitle("Government Welfare Schemes Portal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(244, 247, 246));

        
        allSchemes = SchemeDatabase.getAllSchemes();

        // Top Panel Setup (Header & Filters)
        setupTopPanel();

        // Center Panel Setup (Cards Grid)
        cardsPanel = new JPanel(new GridLayout(0, 2, 15, 15));
        cardsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        cardsPanel.setBackground(new Color(244, 247, 246));

        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        addListeners();
        displaySchemes(allSchemes); // Pehli baar saara data dikhana
    }

    private void setupTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(0, 64, 128));
        topPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Government Welfare Schemes");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(titleLabel);

        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        controlsPanel.setOpaque(false);

        searchField = new JTextField(20);
        String[] categories = {"All Categories", "Agriculture", "Education", "Healthcare"};
        categoryCombo = new JComboBox<>(categories);

        controlsPanel.add(new JLabel("<html><font color='white'>Search:</font></html>"));
        controlsPanel.add(searchField);
        controlsPanel.add(categoryCombo);
        topPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        topPanel.add(controlsPanel);

        add(topPanel, BorderLayout.NORTH);
    }

    private void displaySchemes(List<Scheme> schemes) {
        cardsPanel.removeAll();
        for (Scheme s : schemes) {
            cardsPanel.add(createCard(s));
        }
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }

    private JPanel createCard(Scheme scheme) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(0, 64, 128)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        card.add(new JLabel("<html><h3 style='color:#004080;'>" + scheme.title + "</h3></html>"));
        card.add(new JLabel("<html><b style='color:gray;'>[" + scheme.category + "]</b></html>"));
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(new JLabel("<html><p style='width: 200px;'><b>Overview:</b> " + scheme.desc + "</p></html>"));
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(new JLabel("<html><p style='width: 200px;'><b>Eligibility:</b> " + scheme.eligibility + "</p></html>"));
        card.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton applyBtn = new JButton("Read More");
        applyBtn.setBackground(new Color(40, 167, 69));
        applyBtn.setForeground(Color.WHITE);
        applyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        applyBtn.addActionListener(e -> {
            try { Desktop.getDesktop().browse(new URI(scheme.link)); } 
            catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error opening link."); }
        });

        card.add(applyBtn);
        return card;
    }

    private void addListeners() {
        categoryCombo.addActionListener(e -> filterData());
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filterData(); }
            public void removeUpdate(DocumentEvent e) { filterData(); }
            public void changedUpdate(DocumentEvent e) { filterData(); }
        });
    }

    private void filterData() {
        String searchText = searchField.getText().toLowerCase();
        String selectedCategory = (String) categoryCombo.getSelectedItem();

        List<Scheme> filtered = allSchemes.stream().filter(s -> {
            boolean matchesSearch = s.title.toLowerCase().contains(searchText) || s.desc.toLowerCase().contains(searchText);
            boolean matchesCat = selectedCategory.equals("All Categories") || s.category.equals(selectedCategory);
            return matchesSearch && matchesCat;
        }).collect(Collectors.toList());

        displaySchemes(filtered);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GovSchemePortal().setVisible(true);
        });
    }
}
