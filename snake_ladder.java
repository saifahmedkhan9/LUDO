import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.String.*;

class snake_ladder implements ActionListener
{
	JFrame jfr;
	JButton jb[];
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem,exit,menuItem1;
	int i=0,k=0,player=1,sum=0,toss=1,count=0;
	Random rand=new Random();
	int r=rand.nextInt(100);
	int first_chance1=0,first_chance2=0,store;	

	//TAKING PLAYER NAMES
	
	String player1=JOptionPane.showInputDialog("Enter First player name :");
	String player2=JOptionPane.showInputDialog("Enter Second Player name :");
	
	//FOR SHOWING SNAKES AND LADDER IN BUTTONS
	
	final ImageIcon icon = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\dice1.jpg");
	final ImageIcon imgpink = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\pink.jpg");
	final ImageIcon img31 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\31.jpg");
	final ImageIcon img42 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\42.jpg");
	final ImageIcon img51 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\51.jpg");
	final ImageIcon img53 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\53.jpg");
	final ImageIcon img54 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\54.jpg");
	final ImageIcon img62 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\62.jpg");
	final ImageIcon img73 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\73.jpg");
	final ImageIcon img19 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\19.jpg");
	final ImageIcon img30 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\30.jpg");
	final ImageIcon img41 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\41.jpg");
	final ImageIcon img52 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\52.jpg");
	final ImageIcon img93 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\93.jpg");
	final ImageIcon img82 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\82.jpg");
	final ImageIcon img71 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\71.jpg");
	final ImageIcon img28 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\28.jpg");
	final ImageIcon img17 = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\17.jpg");
	final ImageIcon img6  = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\6.jpg");
	final ImageIcon img64  = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\64.jpg");
	final ImageIcon img75  = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\75.jpg");
	final ImageIcon img86  = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\86.jpg");
	final ImageIcon img97  = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\97.jpg");
	
	int d,u;
	// CHECK FUNCTION TO CHECK IF ANY PLAYER WINS
	public void check()
	{
		if(k<=0 && player==1)
		{
			JOptionPane.showMessageDialog(null,player1+"Won");
		}
		if(k<=0 && player==0)
		{
			JOptionPane.showMessageDialog(null,player2+"Won");
		}
	}
	//CONSTRUCTOR CONTAINTING GUI BASED CODES
	snake_ladder()
	{
		jb=new JButton[101];
		jfr= new JFrame("SNAKE AND LADDER( "+player1+" Vs "+player2+" )");
		jfr.setLayout(null);
		//ASSIGNING VALUES TO BUTTONS IN DECREASING ORDER
		for(i=0;i<101;i++)
		{
			jb[i]=new JButton(String.valueOf(100-i));
			if(i==99)
			{
				jb[i].setText("STRT");
				jb[i].setForeground(Color.RED);
			}
			if(i==0)
			{
				jb[i].setText("END");
			}
			if(i==100)
			{
				jb[i].setText("ROLL");
			}
			jfr.add(jb[i]);
			jb[i].addActionListener(this);
		}
		// GIVING SNAKES AND LADDER IMAGES TO BUTTON
		try
		{
			
			jb[69].setIcon(img31);
			jb[58].setIcon(img42);
			jb[49].setIcon(img51);
			jb[47].setIcon(img53);
			jb[46].setIcon(img54);
			jb[38].setIcon(img62);
			jb[27].setIcon(img73);
			jb[81].setIcon(img19);
			jb[70].setIcon(img30);
			jb[59].setIcon(img41);
			jb[7].setIcon(img93);
			jb[18].setIcon(img82);
			jb[29].setIcon(img71);
			jb[72].setIcon(img28);	
			jb[83].setIcon(img17);	
			jb[94].setIcon(img6);	
			jb[36].setIcon(img64);	
			jb[25].setIcon(img75);	
			jb[14].setIcon(img86);	
			jb[3].setIcon(img97);			
			jb[100].setIcon(imgpink);
		}
		catch(Exception e){

		}
		jfr.setLayout(new  GridLayout(10,10,0,0));
		jfr.setSize(800,700);
		jfr.setVisible(true);
		// TOSSING CODE STARTS 
		JOptionPane.showMessageDialog(null,"Tossing.. Press<Enter> to see result","Lets Toss..!!!",JOptionPane.PLAIN_MESSAGE);
		if(r%2==0)
		{
			player=1; // IF PLAYER1 WIN THE TOSS
			toss=1;
			JOptionPane.showMessageDialog(null,player1+" You Won the Toss","Congrats",JOptionPane.PLAIN_MESSAGE);

		}
		else
		{
			player=0; // IF PLAYER2 WIN THE TOSS
			toss=0;
			JOptionPane.showMessageDialog(null,player2+" You Won the Toss","Congrats",JOptionPane.PLAIN_MESSAGE);
		}
		// TOSSING CODE ENDS
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	//ONCLICK BUTTON EVENT
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jb[100]) // WHEN THE TOSSING BUTTON IS CLICKED
		{
			sum=rand.nextInt(7); // CREATES RANDOM NUMBER FROM 0 TO 6
			if(sum!=0) // AS DICE DO NOT CONTAINS 0 VALUE
			{
				if(first_chance2==1 || first_chance1==1) // NOT THE FIRST CHANCE
				{
					for(i=0;i<100;i++)
					{
						if((jb[i].getText()).contains("*") && player==1) // FOR PLAYER1 SYMBOL * IS ASSIGNED IN RED COLOR
						{
							JOptionPane.showMessageDialog(null,player1+" its a "+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);
							
							k=i-sum;
							check();
							if((k==46 || k==27 || k==72 || k==7) && sum!=6) // FOR SNAKE JUMP
							{
								if(k==46)
								{
									jb[k].setText("54");
									k=69;	
								}
								else if(k==27)
								{
									jb[k].setText("73");
									k=49;
								}
								else if(k==72)
								{
									jb[k].setText("18");
									k=94;
								}
								else if(k==7)
								{
									jb[k].setText("93");
									k=29;
								}
							}

							else if((k==81 || k==36) && sum!=6) //FOR LADDER JUMP
							{
								if(k==81)
								{
									jb[k].setText("19");
									k=59;
								}
								else if(k==36)
								{
									jb[k].setText("64");
									k=3;
								}
							}

							if((jb[i].getText()).contains("o")) // WHEN BOTH PLAYER ARE ON THE SAME PLACE
							{	
								jb[i].setText("o");
								jb[i].setForeground(Color.BLUE); 
							}	
							else
								jb[i].setText(String.valueOf(100-i)); //AGAIN PUTTING THE NUMBERS ON BUTTON 
							
							if((jb[k].getText()).contains("o")) // WHEN ON THE NEW PLACE THE PLAYER2 IS ALREADY PRESENT
								jb[k].setText("* o");
							else
								jb[k].setText("*");
							jb[k].setForeground(Color.RED); // PLAYER1 GETS * MARK IN RED COLOR
							
							count=0;
							store=k; 	//RESTORE THE * POSITION FOR PLAYER1
							while(sum==6 && count<3) // WHEN 2 TIMES 6 COMES
							{
								if(count==2) // WHEN 3RD TIME 6 COMES THEN RESTORE PREVIOUS VALUE AND EXIT FROM LOOP
								{
									k=store;
								}
								sum=rand.nextInt(7);
								if(sum==0)
									sum=1;
								JOptionPane.showMessageDialog(null,player1+" its a 6+"+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);
								if((jb[k].getText()).contains("o")) 
								{	
									jb[k].setText("o");
									jb[k].setForeground(Color.BLUE);
								}	
								else
									jb[k].setText(String.valueOf(100-k));
								k=k-sum;
								check();
								
								if((jb[k].getText()).contains("o"))
									jb[k].setText("* o");
								else
									jb[k].setText("*");
								jb[k].setForeground(Color.RED);

								count++;	

							}	

						}

						else if((jb[i].getText()).contains("o") && player==0) // FOR PLAYER1 SYMBOL O IS ASSIGNED IN BLUE COLOR
						{
							JOptionPane.showMessageDialog(null,player2+" its a "+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);

							k=i-sum;
							check();
							if((k==46 || k==27 || k==72 || k==7) && sum!=6) // FOR SNAKE JUMP
							{
								if(k==46)
								{
									jb[k].setText("54");
									k=69;	
								}
								else if(k==27)
								{
									jb[k].setText("73");
									k=49;
								}
								else if(k==72)
								{
									jb[k].setText("18");
									k=94;
								}
								else if(k==7)
								{
									jb[k].setText("93");
									k=29;
								}
							}
							if((k==81 || k==36)&& sum!=6) //FOR LADDER JUMP
							{
								if(k==81)
								{
									jb[k].setText("19");
									k=59;
								}
								else if(k==36)
								{
									jb[k].setText("64");
									k=3;
								}
							}
							if((jb[i].getText()).contains("*")) //WHEN BOTH ARE AT THE SAME PLACE
							{
								jb[i].setText("*");

								jb[i].setForeground(Color.RED);
							}
							else
								jb[i].setText(String.valueOf(100-i));

							if((jb[k].getText()).contains("*"))	// WHEN ON THE NEW PLACE THE PLAYER2 IS ALREADY PRESENT
								jb[k].setText("* o");
							else
								jb[k].setText("o");
							jb[k].setForeground(Color.BLUE); // PLAYER2 HAVE o MARK IN BLUE COLOR
							count=0;
							store=k;

							while(sum==6 && count<3) //SAME WHILE LOOP FOR PLAYER2
							{
								if(count==2)
								{
									k=store;
									break;
								}
								sum=rand.nextInt(7);
								if(sum==0)
									sum=1;
								JOptionPane.showMessageDialog(null,player2+" its a 6+"+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);

								if((jb[k].getText()).contains("*"))
								{
									jb[k].setText("*");

									jb[k].setForeground(Color.RED);
								}
								else
									jb[k].setText(String.valueOf(100-k));
								k=k-sum;
								check();

								if((jb[k].getText()).contains("*"))	
									jb[k].setText("* o");
								else
									jb[k].setText("o");
								jb[k].setForeground(Color.BLUE);	

								count++;							

							}

						}
					}
				}

				if(toss==1)
				{	
					if(first_chance1==0)	
						JOptionPane.showMessageDialog(null,player1+" its a "+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);
					// JOptionPane.showMessageDialog(null,player1+" its a "+sum);
					if(first_chance1==0 && (sum==6 || sum==1)) // IF ITS A FIRST CHANCE
					{	
						i=0;
						first_chance1=1;
						sum=rand.nextInt(7);
						if(sum==0)
							sum=1;
						JOptionPane.showMessageDialog(null,player1+" its a "+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);
						i=100-sum;
						
						if((jb[i].getText()).contains("o"))
							jb[i].setText("* o");
						else
							jb[i].setText("*");
						jb[i].setForeground(Color.RED);

						
					}

					toss=0;
					player=0; //FOR PLAYER2 CHANCE
				}
				else
				{
					if(first_chance2==0)
						JOptionPane.showMessageDialog(null,player2+" its a "+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);
					if(first_chance2==0 && (sum==6 || sum==1)) //IF ITS A FIRST CHANCE
					{
						i=0;	
						first_chance2=1;
						sum=rand.nextInt(7);
						if(sum==0)
							sum=1;
						JOptionPane.showMessageDialog(null,player2+" its a "+sum,"You",JOptionPane.INFORMATION_MESSAGE, icon);
						i=100-sum;
						
						if((jb[i].getText()).contains("*"))
							jb[i].setText("* o");
						else
							jb[i].setText("o");
						jb[i].setForeground(Color.BLUE);

					}

					toss=1;
					player=1; //FOR PLAYER1 CHANCE
				}

			}
		}
	}

	public static void main(String args[])
	{
		new snake_ladder();
	}

}
