import javax.swing.JOptionPane;

public class Ordine {

    public static void main(String[] args) {
       Splash splash = new Splash();
       splash.setVisible(true);
       Aspect aspect = new Aspect();
	try{
            for (int i = 0; i <= 100; i++){
                Thread.sleep(20);
                splash.lProcent.setText(Integer.toString(i) + "%");
                splash.lBar.setValue(i);
                if(i == 100){
                    splash.setVisible(false);
                    aspect.setVisible(true);
                }
            }
        }catch (Exception e){
            System.out.println("Nu merge ");
	        }
        }
        
    }
    


