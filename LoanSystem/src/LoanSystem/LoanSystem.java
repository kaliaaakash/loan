package LoanSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;



public class LoanSystem {

	private JFrame frame;
	private JTextField txtInterestRate;
	private JTextField txtNumberOfYears;
	private JTextField txtMonthlyPayment;
	private JTextField txtAmtOfLoan;
	private JTextField txtTolalPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanSystem window = new LoanSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoanSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 28, 1043, 66);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoanManagementSystem = new JLabel("   Loan Management System Calculator");
		lblLoanManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblLoanManagementSystem.setBounds(0, 0, 1033, 61);
		panel.add(lblLoanManagementSystem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 551, 1043, 72);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLoanCalculator = new JButton("Loan Calculator");
		btnLoanCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double InterestRate = Double.parseDouble(txtInterestRate.getText());
				double monthlyInterestRate = InterestRate /1200;
				int numberOfYears = Integer.parseInt(txtNumberOfYears.getText());
				double loanAmount = Double.parseDouble(txtAmtOfLoan.getText());
				
				
				//------------------------------------Monthly Payment-------------------------------------------------
				
				double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1/Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
				String imonthlyPayment;
				imonthlyPayment = Double.toString(monthlyPayment);
				imonthlyPayment = String.format("€%.2f",monthlyPayment);
				txtMonthlyPayment.setText(imonthlyPayment);
				
				//---------------------------------Total Payment-----------------------------------------------------
				
				double totalPayment = monthlyPayment * numberOfYears * 12;
				String itotalPayment;
				itotalPayment = String.format("€%.2f",totalPayment);
				txtTolalPayment.setText(itotalPayment);
				
				
			}
		});
		btnLoanCalculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLoanCalculator.setBounds(10, 25, 178, 36);
		panel_1.add(btnLoanCalculator);
		
		JButton btnGenerateRecipt = new JButton("Generate Receipt");
		btnGenerateRecipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String InterestRate = String.format(txtInterestRate.getText());
				String NumberOfYears = String.format(txtNumberOfYears.getText());
				String AmtOfLoan = String.format(txtAmtOfLoan.getText());				
				String MonthlyPayment = String.format(txtMonthlyPayment.getText());
				String TolalPayment = String.format(txtTolalPayment.getText());				
				 //===============================================
				int refs = 1325 +(int) (Math.random()*4238);
				 //============================================				
				 Calendar timer = Calendar.getInstance();	
				 timer.getTime();
				 SimpleDateFormat tTime= new SimpleDateFormat ("HH:mm:ss");
				 tTime.format(timer.getTime());
				 SimpleDateFormat Tdate= new SimpleDateFormat ("dd-mm-yyyy");
				 Tdate.format(timer.getTime());
				 //=======================================
				/* textArea.append("\tLoan Management System\n" +
				"Reference:\t\t\t" + refs +
				"\n===================================\t" +
				"\nInterest Rate:\t\t\t" + InterestRate +
				"\nRepayment years:\t\t" + NumberOfYears +
				"\nAmount of Loan: \t\t\t" + "€" + AmtOfLoan +
				"\nMonthly Payment:\t\t" + MonthlyPayment +
				"\nTotal Payment:\t\t\t" + TolalPayment +
						
				"\n===================================\t" +
				"\nDate:" + Tdate.format(timer.getTime()) +
				"\t\tTime" + tTime.format(timer.getTime())+
						 "\n\n\t\tThank you\n");*/
												
						

						
			}
		});
		btnGenerateRecipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGenerateRecipt.setBounds(198, 25, 197, 36);
		panel_1.add(btnGenerateRecipt);
		
		JButton btnResetCalculator = new JButton("Reset Calculator");
		btnResetCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInterestRate.setText(null);
				txtNumberOfYears.setText(null);
				txtAmtOfLoan.setText(null);
				txtMonthlyPayment.setText(null);
				txtTolalPayment.setText(null);
							
				
			}
		});
		btnResetCalculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnResetCalculator.setBounds(405, 25, 187, 36);
		panel_1.add(btnResetCalculator);
		
		JButton btnExitCalculator = new JButton("Exit Calculator");
		btnExitCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Lpan Management System",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
					
				
			}
		});
		btnExitCalculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExitCalculator.setBounds(602, 25, 169, 36);
		panel_1.add(btnExitCalculator);
		
		JLabel lblNewLabel = new JLabel("Enter Interest Rate e.g.4.5");
		lblNewLabel.setBounds(10, 118, 448, 41);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number of Years, e.g 4 as integer");
		lblEnterNumberOf.setBounds(10, 191, 408, 41);
		lblEnterNumberOf.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblEnterNumberOf);
		
		JLabel lblEnterAmountOf = new JLabel("Enter Amount of Loan");
		lblEnterAmountOf.setBounds(10, 265, 308, 41);
		lblEnterAmountOf.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblEnterAmountOf);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment");
		lblMonthlyPayment.setBounds(10, 348, 276, 41);
		lblMonthlyPayment.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblMonthlyPayment);
		
		JLabel lblTotalPayment = new JLabel("Total Payment");
		lblTotalPayment.setBounds(10, 436, 308, 41);
		lblTotalPayment.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblTotalPayment);
		
		txtInterestRate = new JTextField();
		txtInterestRate.setBounds(445, 122, 198, 34);
		txtInterestRate.setHorizontalAlignment(SwingConstants.CENTER);
		txtInterestRate.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(txtInterestRate);
		txtInterestRate.setColumns(10);
		
		txtNumberOfYears = new JTextField();
		txtNumberOfYears.setBounds(445, 195, 198, 34);
		txtNumberOfYears.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumberOfYears.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNumberOfYears.setColumns(10);
		frame.getContentPane().add(txtNumberOfYears);
		
		txtMonthlyPayment = new JTextField();
		txtMonthlyPayment.setBounds(445, 352, 198, 34);
		txtMonthlyPayment.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonthlyPayment.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtMonthlyPayment.setColumns(10);
		frame.getContentPane().add(txtMonthlyPayment);
		
		txtAmtOfLoan = new JTextField();
		txtAmtOfLoan.setBounds(445, 269, 198, 34);
		txtAmtOfLoan.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmtOfLoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtAmtOfLoan.setColumns(10);
		frame.getContentPane().add(txtAmtOfLoan);
		
		txtTolalPayment = new JTextField();
		txtTolalPayment.setBounds(445, 440, 198, 34);
		txtTolalPayment.setHorizontalAlignment(SwingConstants.CENTER);
		txtTolalPayment.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTolalPayment.setColumns(10);
		frame.getContentPane().add(txtTolalPayment);
	}
}
