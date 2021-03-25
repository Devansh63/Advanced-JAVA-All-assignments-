import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ColorListPanel extends JPanel {

	private DefaultListModel<Color> listmode;
	private JList<Color> List;
	private JPanel button;
	private JButton colorAdder, colorDeleting;
	
	public ColorListPanel() {
		
		setLayout (new BorderLayout(0,400));
		
		listmode = new DefaultListModel<Color>();
		List = new JList<Color>(listmode);
		List.setVisibleRowCount(4);
		add(new JScrollPane(List),BorderLayout.NORTH);
		List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		button = new JPanel();
		colorAdder = new JButton("Add Color");
		button.add(colorAdder);
		
		colorDeleting = new JButton ("Delete Color");
		button.add(colorDeleting);
		add(button);
		//,BorderLayout.CENTER
	}
	public int getindex() {
		return List.getSelectedIndex();
	}
	public void setindex(int Index) {
		List.setSelectedIndex(Index);
	}
	public DefaultListModel<Color> getDim() {
		return listmode;
	}

	public void setDim(DefaultListModel<Color> dim) {
		this.listmode = dim;
	}

	public JList<Color> getList() {
		return List;
	}

	public void setList(JList<Color> list) {
		this.List = list;
	}

	public JButton getAddColor() {
		return colorAdder;
	}

	public void setAddColor(JButton addColor) {
		this.colorAdder = addColor;
	}

	public JButton getDeleteColor() {
		return colorDeleting;
	}

	public void setDeleteColor(JButton deleteColor) {
		this.colorDeleting = deleteColor;
	}
	
}
