package presentation;

import javax.swing.JPanel;

import javax.swing.JFrame;

import javax.swing.JLabel;



import java.awt.Color;

import java.awt.Rectangle;

import java.util.Calendar;

import java.sql.Date;

import java.util.Collection;





import javax.swing.ButtonGroup;

import javax.swing.DefaultComboBoxModel;

import javax.swing.DefaultListModel;

import javax.swing.JTextField;

import javax.swing.JComboBox;

import javax.swing.JRadioButton;



import businessLogic.OfferManager;

import businessLogic.MyOfferManager;



import javax.swing.JButton;

import javax.swing.JScrollPane;

import javax.swing.JList;

import javax.swing.SwingConstants;



import domain.Offer;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;





import domain.Offer;

public class OfferBooking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField city = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextField day = null;
	private JComboBox month = null;
	private JTextField year = null;
	private JLabel roomType;
	private JRadioButton tripleRooms = null;
	private JRadioButton doubleRooms = null;
	private JRadioButton singleRooms = null;
	private JComboBox offerList3 = null;

	private ButtonGroup fareButtonGroup = new ButtonGroup();  //  @jve:decl-index=0:
	private JButton lookforOffers = null;
	private JButton bookOffer = null;
	
	
	private DefaultComboBoxModel monthNames = new DefaultComboBoxModel();
	private DefaultComboBoxModel offerInfo = new DefaultComboBoxModel();
	
	private Collection coleccion;
	
	private OfferManager businessLogic;  //  @jve:decl-index=0:
	private JLabel monthLabel = null;
	private JLabel dayLabel = null;
	private JLabel searchResult = null;
	private JLabel errorFecha = null;
	
	private Offer selectedOffer;
	
	private boolean noMasHab=false;

	/**
	 * This is the default constructor
	 */
	public OfferBooking() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		this.setSize(457, 361);
		this.setContentPane(getJContentPane());
		this.setTitle("RuralHouses Offer Book");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			searchResult = new JLabel();
			searchResult.setBounds(new Rectangle(54, 176, 325, 20));
			searchResult.setHorizontalAlignment(SwingConstants.CENTER);
			searchResult.setHorizontalTextPosition(SwingConstants.CENTER);
			searchResult.setText("");
			dayLabel = new JLabel();
			dayLabel.setBounds(new Rectangle(342, 61, 50, 28));
			dayLabel.setText("Day:");
			monthLabel = new JLabel();
			monthLabel.setBounds(new Rectangle(126, 63, 52, 26));
			monthLabel.setText("Month:");
			roomType = new JLabel();
			roomType.setBounds(new Rectangle(6, 95, 90, 32));
			roomType.setText("Room Type:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(7, 63, 111, 28));
			jLabel2.setText("Year:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(6, 10, 137, 22));
			jLabel.setText("City:");
			errorFecha = new JLabel("");
			errorFecha.setForeground(Color.RED);
			errorFecha.setBounds(81, 38, 304, 22);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getCity(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getDay(), null);
			jContentPane.add(getMonth(), null);
			jContentPane.add(getYear(), null);
			jContentPane.add(roomType, null);
			jContentPane.add(getTripleRooms(), null);
			jContentPane.add(getDoubleRooms(), null);
			jContentPane.add(getSingleRooms(), null);
			jContentPane.add(getLookForOffers(), null);
			jContentPane.add(getBookOffer(), null);
			jContentPane.add(getOfferList3(), null);
			jContentPane.add(monthLabel, null);
			jContentPane.add(dayLabel, null);
			jContentPane.add(searchResult, null);
			jContentPane.add(errorFecha,null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes departingCity	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCity() {
		if (city == null) {
			city = new JTextField();
			city.setBounds(new Rectangle(98, 9, 294, 24));
		}
		return city;
	}

	/**
	 * This method initializes day	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDay() {
		if (day == null) {
			day = new JTextField();
			day.setBounds(new Rectangle(371, 63, 70, 29));
		}
		return day;
	}

	/**
	 * This method initializes month	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getMonth() {
		if (month == null) {
			month = new JComboBox<String>();
			month.setBounds(new Rectangle(170, 64, 165, 28));
			
			
			month.setModel(monthNames);
			monthNames.addElement("January");
			monthNames.addElement("February");
			monthNames.addElement("March");
			monthNames.addElement("April");
			monthNames.addElement("May");
			monthNames.addElement("June");
			monthNames.addElement("July");
			monthNames.addElement("August");
			monthNames.addElement("September");
			monthNames.addElement("October");
			monthNames.addElement("November");
			monthNames.addElement("December");
			
			
		}
		return month;
	}

	/**
	 * This method initializes year	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getYear() {
		if (year == null) {
			year = new JTextField();
			year.setBounds(new Rectangle(45, 64, 65, 30));
		}
		return year;
	}

	/**
	 * This method initializes business	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getTripleRooms() {
		if (tripleRooms == null) {
			tripleRooms = new JRadioButton();
			tripleRooms.setBounds(new Rectangle(98, 93, 80, 36));
			tripleRooms.setText("Triple");
			fareButtonGroup.add(tripleRooms);
		}
		return tripleRooms;
	}

	/**
	 * This method initializes first	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getDoubleRooms() {
		if (doubleRooms == null) {
			doubleRooms = new JRadioButton();
			doubleRooms.setBounds(new Rectangle(180, 97, 79, 29));
			doubleRooms.setText("Double");
			
			fareButtonGroup.add(doubleRooms);
		}
		return doubleRooms;
	}

	/**
	 * This method initializes tourist	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSingleRooms() {
		if (singleRooms == null) {
			singleRooms = new JRadioButton();
			singleRooms.setBounds(new Rectangle(271, 98, 121, 27));
			singleRooms.setSelected(true);
			singleRooms.setText("Single");
			fareButtonGroup.add(singleRooms);
		}
		return singleRooms;
	}

	public void setBusinessLogic(OfferManager g) {businessLogic = g;}
	
	/**
	 * This method initializes lookForOffers	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLookForOffers() {
		if (lookforOffers == null) {
			lookforOffers = new JButton();
			lookforOffers.setBounds(new Rectangle(81, 134, 264, 36));
			lookforOffers.setText("Look for Concrete Offers");
			lookforOffers.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					bookOffer.setEnabled(true);
					offerInfo.removeAllElements();
					bookOffer.setText("");
					try{
						int m = month.getSelectedIndex()+1; // Para montar el string con la fecha y formato yyyy-mm-dd
						int d = Integer.parseInt(day.getText());
						String monthStr = (m>=10)?String.valueOf(m):"0"+m;
						String dayStr = (d>=10)?String.valueOf(d):"0"+d;					
						Date date = Date.valueOf(Integer.parseInt(year.getText())+"-"+monthStr+"-"+dayStr);					
					
					// Con jre7 bastaría lo siguiente:
	
						coleccion=businessLogic.getConcreteOffers(city.getText(),date);
						for (Object v : coleccion)  offerInfo.addElement(v); 
						if (coleccion.isEmpty()){
							errorFecha.setText("");
							searchResult.setText("No offers in that city in that date");
							bookOffer.setEnabled(false);
						}
						else {
							errorFecha.setText("");
							searchResult.setText("Choose an available offer in this list:");
						}
					}
					catch (Exception exc){
						searchResult.setText("");
						errorFecha.setText("ERROR: Wrong date selected, please try again");
						bookOffer.setEnabled(false);
					}
					
				}
					
					
				}
			);
		}
		return lookforOffers;
	}

	/**
	 * This method initializes jList1	
	 * 	
	 * @return javax.swing.JList	
	 */

	private JComboBox<Offer> getOfferList3() {
		if (offerList3 == null) {
			offerList3 = new JComboBox();
			offerList3.setBounds(75, 200, 304, 36);
			offerList3.setModel(offerInfo);
			offerList3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (offerList3.getItemCount()>0){ // A este método se le llama también cuando se hace un removeAllElements del JComboBox, 
													// por lo que podría estar la selección vacía y dar un error
						selectedOffer = (Offer) offerList3.getSelectedItem();
						int num=0;
						boolean error=false;
						if (tripleRooms.isSelected()) { 
							num=selectedOffer.getTripleNumber();
							if (num==0) error=true;
						}
						else if (doubleRooms.isSelected()) {
							num=selectedOffer.getDoubleNumber();
							if (num==0) 
								error=true;
						}
						else if (singleRooms.isSelected()) {
							num=selectedOffer.getSingleNumber();
							if (num==0) 
								error=true;
						}
						
						if (error) {
							bookOffer.setEnabled(false);
							bookOffer.setText("No available offer for that room type");
						}	
						else{
							bookOffer.setEnabled(true);
							bookOffer.setText("Book this offer: "+selectedOffer);
						}
							  
					}
				}
			});
			
		}
		return offerList3;
	}

	/**
	 * This method initializes getBookOffer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBookOffer() {
		if (bookOffer== null) {
			bookOffer = new JButton();
			bookOffer.setBounds(new Rectangle(28, 262, 404, 38));
			bookOffer.setEnabled(false);
			bookOffer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int num=0;
					int id=0;
					boolean error=false;
					if (tripleRooms.isSelected()) { 
						num=selectedOffer.getTripleNumber();
						if (num>0){
							id=selectedOffer.getId();
							businessLogic.ModHabi(id, 3);
							selectedOffer.setTripleNumber(num-1);  
						}else error=true;
						}
						
					else if (doubleRooms.isSelected()) {
						num=selectedOffer.getDoubleNumber();
						if (num>0){ 
							id=selectedOffer.getId();
							businessLogic.ModHabi(id, 2);
							selectedOffer.setDoubleNumber(num-1); 
							} else error=true;
					}
					else if (singleRooms.isSelected()) {
						num=selectedOffer.getSingleNumber();
						if (num>0){
							id=selectedOffer.getId();
							businessLogic.ModHabi(id, 1);
							selectedOffer.setSingleNumber(num-1); 
						}else error=true;
					}
					if (error) {
						bookOffer.setText("Error: There were no offers available!");
						bookOffer.setEnabled(false);
					}
					else bookOffer.setText("Booked. #rooms left: "+(num-1));
					bookOffer.setEnabled(false);
				}
			});
		}
		return bookOffer;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OfferBooking p = new OfferBooking();
		p.setBusinessLogic(new MyOfferManager());
		p.setVisible(true);
		
	}
	
}  //  @jve:decl-index=0:visual-constraint="18,9"

