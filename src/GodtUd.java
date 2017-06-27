import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;


public class GodtUd extends JFrame {

	private JPanel contentPane;
	private ArrayList<Pixel> enList=null;
	private SavePaintInfo paint=new SavePaintInfo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GodtUd frame = new GodtUd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void lavhentData() throws Exception
	{
		paint.SavePaintInfo();
		enList=paint.LoadPaintInfo();
	}
	
	/**
	 * Create the frame.
	 */
	public GodtUd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTextField text=new JTextField("Test");
		text.setEnabled(false);
		contentPane.add(text);
		
		JButton jbut=new JButton("Reset");
		jbut.setSize(35, 35);
		SpringLayout sp=new SpringLayout();
		contentPane.setLayout(sp);
		contentPane.add(jbut);
		
		jbut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread aThread=new Thread()
						{
						public void run()
						{
							try
							{
							lavhentData();
							repaint();
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}	
						}
						
						};
						aThread.start();
				// TODO Auto-generated method stub
				
				//System.out.println("der erpush");
			}
		});
		
		
		
		
	}

	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0); 
		//arg0.clearRect(0, 0, 880, 880);
		arg0.clearRect(200,200, 300, 300);
		arg0.setColor(new Color(0,0,0));
		arg0.drawRect(200,200, 300, 300);
		// TODO Auto-generated method stub
		//System.out.println("Inde i paint ");
		arg0.drawString("Hent data fra filen", 193, 130);
		if (enList!=null)
		{
		for (Pixel aPix: enList)
			{	
			//	arg0.fillRect(41, 41, 1, 1);
			if (aPix.getY()>200 && aPix.getX()>200 && aPix.getY()<500 && aPix.getX()<501)
			{
			if (aPix.getColor()==1)
				{
				arg0.setColor(new Color(255,0,0));
				}
			else
				if (aPix.getColor()==0)
				{
				arg0.setColor(new Color(0,0,255));
				}
			try
			{
			Thread.sleep(103L);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			arg0.fillRect(aPix.getX(), aPix.getY(), 1, 1);
			}
		}
		}
		
	}
	

}
