import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaPanel extends JPanel {
	private JTextArea Txt_Field;
	public TextAreaPanel() {
		Txt_Field = new JTextArea();
		
		Txt_Field.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(Txt_Field);
		scrollPane.setPreferredSize(new Dimension(400, 650));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
	}

	public JTextArea getTextField() {
		return Txt_Field;
	}

	public void setTextField(JTextArea textField) {
		this.Txt_Field = textField;
	}

}
