
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.AbstractListModel;


public class CarteDeTelefon extends AbstractListModel {
    //Comparatori dupa fiecare dintre campuri 

    Comparator<Abonat> dupaNume = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getNume().compareTo(a2.getNume());
        }
    };

    Comparator<Abonat> dupaPrenume = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getPrenume().compareTo(a2.getPrenume());
        }
    };

    Comparator<Abonat> dupaNrTel = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getNrTel().compareTo(a2.getNrTel());
        }
    };

    Comparator<Abonat> dupaCNP = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getCNP().compareTo(a2.getCNP());

        }
    };
    
    // Colectia

    public List ab;

    public CarteDeTelefon() {
        this.ab = new LinkedList();
        
    }

    @Override

    public int getSize() {
        return ab.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ab.get(index);
    }

    public void adauga(Abonat a) {
        ab.add(0, a);
        fireContentsChanged(this, -1, -1);
    }

    public void adauga(String getNume, String getPrenume, String getNrTel, String getCNP) {
        adauga(new Abonat(getNume, getPrenume, getNrTel, getCNP));
    }

    public void sterge(int pozitie) {
        ab.remove(pozitie);
        fireContentsChanged(this, -1, -1);
    }

    public void stergeTot() {
        ab.clear();
        fireContentsChanged(this, -1, -1);
    }
     
    
   //o lista care primeste elementele din cautare
/*    public LinkedList<Abonat> list= new LinkedList<Abonat>();  
    public void cautare(String text,List ab){
      for (int p = 0; p< ab.size(); p++) {
          
               Abonat a= (Abonat)ab.get(p);
               String s= a.toString().toLowerCase();
               if(s.contains(text))
                   list.add(a);
          }
        fireContentsChanged(this, -1, -1);
      }
    */
    
    //metoda pentru cautare
    //cautarea se face pe un principiu destul de simplu: se cauta in model secventa
    //elementele care o contin raman in model, celelalte sunt sterse
    //cand se sterge filtrul de cautare se incarca elementele din fisier
    public void cautare(String text){
        
        for (Iterator i = ab.listIterator(); i.hasNext();)
            if(i.next().toString().toLowerCase().contains(text.toLowerCase()) != true ){
              
                updateJlist();
            }
       //|| i.next().toString().contains(text)!=true         
    }
    
    public void updateJlist() {
        fireContentsChanged(this, -1, -1);
    }
   
    //sortarile dupa diferitele criterii in colectie si in componenta grafica
    public void sortDupaNume() {
        Collections.sort(ab, dupaNume);
        fireContentsChanged(this, -1, -1);
    }

    public void sortDupaPrenume() {
        Collections.sort(ab, dupaPrenume);
        fireContentsChanged(this, -1, -1);
    }

    public void sortDupaNrTel() {
        Collections.sort(ab, dupaNrTel);
        fireContentsChanged(this, -1, -1);
    }

    public void sortDupaCNP() {
        Collections.sort(ab, dupaCNP);
        fireContentsChanged(this, -1, -1);
    }
    
    //metode pentru serializare 
    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ab = (List) ois.readObject();
        ois.close();
        fis.close();

    }

    public void save(File f) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ab);
        oos.close();
        fos.close();
    }
}
