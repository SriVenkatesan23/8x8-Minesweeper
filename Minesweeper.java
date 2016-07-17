import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import java.applet.Applet;
public class Minesweeper extends Applet implements MouseListener  {

	Board gameBoard = new Board(59,85,560,560); //creating gameBoard
	boolean begin=false;

	public void init()  //sets initial characteristics for the gameBoard
	{
		setSize(700,700);
		addMouseListener(this);
		setFocusable(true);
		setBackground(Color.darkGray);
	}
	public void paint(Graphics g)
	{
		g.setFont(new Font("Chiller", Font.PLAIN, 70));
		gameBoard.display(g);

		if(!gameBoard.gameOver && !gameBoard.win){
			if(!begin){
				g.drawString("MINESWEEPER", 76, 65);
				begin=true;
			}else{
				g.setFont(new Font("Chiller", Font.PLAIN, 18));
				g.drawString("Tiles Opened: "+gameBoard.tilesOpened, 76, 30);
				g.drawString("Number Of Mines: 10", 76, 60);
			}
		}
		else if(gameBoard.win){
			try {
				for(int i=0;i<6;i++){
					g.drawString("YOU WIN", 76, 65);
					g.setColor(Color.darkGray);
					Thread.sleep(300);
					g.drawString("YOU WIN", 76, 65);
					g.setColor(Color.CYAN.darker());
					Thread.sleep(300);
				}             //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			System.exit(0);
		}

		else if(gameBoard.gameOver){
			try {
				g.setFont(new Font("Chiller", Font.PLAIN, 30));
				for(int i=0;i<6;i++){
					g.drawString("GAME OVER", 76, 65);
					g.setColor(Color.darkGray);
					Thread.sleep(300);
					g.drawString("GAME OVER", 76, 65);
					g.setColor(Color.CYAN.darker());
					Thread.sleep(300);
				}
				//1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			System.exit(0);
		}
	}



	public void mouseClicked(MouseEvent e) {
		gameBoard=gameBoard.updateBoard(e.getX(), e.getY());
		repaint();	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
