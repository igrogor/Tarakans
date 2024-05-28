import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ObjectListDialog extends JDialog {
    ObjectListDialog(JFrame parent, TreeMap<Integer, Integer> birthTimes) {
        super(parent, "Список объектов", true);

        JList<String> objectList = new JList<>(new DefaultListModel<>());
        DefaultListModel<String> model = (DefaultListModel<String>) objectList.getModel();
        TreeMap<Integer, Integer> copiedBirthTimes = new TreeMap<>(birthTimes);

        // for (Map.Entry<Integer, Integer> entry : birthTimes.entrySet()) {
        //     model.addElement("ID: " + entry.getKey() + ", Время рождения: " + entry.getValue());
        // }
        for (Map.Entry<Integer, Integer> entry : copiedBirthTimes.entrySet()) {
            model.addElement("ID: " + entry.getKey() + ", Время рождения: " + entry.getValue());
        }
        
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(new JScrollPane(objectList), BorderLayout.CENTER);
        setContentPane(contentPane);

        pack();
        setLocationRelativeTo(parent);
    }
}