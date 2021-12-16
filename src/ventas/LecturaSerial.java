package ventas;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.swing.JOptionPane;

import alimentos.ListaAlimentosAd;
  public class LecturaSerial  {
	  //inicializamos y decalramos variables
	CommPortIdentifier portId;
	Enumeration puertos;
	SerialPort serialport;
	static InputStream entrada = null;
	Thread t;
	//private String puertoCom="";
	private boolean estadoPuertos=true;
	private ListaAlimentosAd productosAd;
	private LeerSerial leerSerial;
	
	
	
	//creamos un constructor para realizar la conexion del puerto
	
	
  	public LecturaSerial(ListaAlimentosAd ad) {
      //  super();
  		this.productosAd= ad;
      
  }
  	public LecturaSerial() {
        //  super();
    		//this.productosAd= ad;
        
    }
  	public void iniLectura() {
  	  puertos=CommPortIdentifier.getPortIdentifiers();
  	  this.leerSerial=new LeerSerial();
      t = new Thread(leerSerial);
      
      while (puertos.hasMoreElements()&&estadoPuertos) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar 
      	//hasmorelements mientras tenga mas eleementos
      	portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorre uno por uno
      	System.out.println(portId.getName()); //puertos disponbibles
      	if (portId.getName().equalsIgnoreCase(portId.getName())) {
      		try {
      		serialport= (SerialPort)portId.open("LecturaSerial", 2);//tiempo en ms
  				entrada = serialport.getInputStream();//esta variable del tipo InputStream obtiene el dato serial
 				t.start(); // inciamos el hilo para realizar nuestra accion de imprimir el dato serial
   		 
			} catch (Exception e) {
			//	LecturaSerialRec();
				System.out.println("error en el puerto");
				estadoPuertos=false;
			} } }
  	}
  	
  	
  	
  	
    private void LecturaSerialRec() {
		// TODO Auto-generated method stub
		System.out.println("error interno");
	}





	//con este metodo del tipo thread relaizamos 

  	public static class LeerSerial implements Runnable {
	   int aux;
	   boolean estadoHilo=true;
	   private String peso="";
	   private String pesoFin="";
       public void run () {
    	   while(estadoHilo){
    		  try {
				aux = entrada.read(); // aqui estamos obteniendo nuestro dato serial
				Thread.sleep(10);
 				if (aux>0) {
 					if (((char)aux<58)&&((char)aux>45)||(char)aux==103) {
 						
 						if (aux==103) {
 						
 							pesoFin=peso;
 							System.out.println(pesoFin);
 							peso="";
						}else
 						//System.out.print((char)aux);//imprimimos el dato serial
 						peso+=(char)aux;
					}
					
				}	
 				
			} catch (Exception e) {
				
					System.out.println("error en el hilo");
					estadoHilo=false;
					//this.finalize();
			
					// TODO Auto-generated catch block
				

 			}
    		  } }
	public String getPesoFin() {
		return pesoFin;
	}
	public void setPesoFin(String pesoFin) {
		this.pesoFin = pesoFin;
	}
       
       
  }public static void main(String[] args) {
	  LecturaSerial lecturaSerial = new LecturaSerial();
	  //lecturaSerial.setPuertoCom("COM8");
	 lecturaSerial.iniLectura();
	
	 //JOptionPane.showMessageDialog(null, "peso seleccionado "+lecturaSerial.getLeerSerial().getPesoFin() );
 		 }
public LeerSerial getLeerSerial() {
	return leerSerial;
}
public void setLeerSerial(LeerSerial leerSerial) {
	this.leerSerial = leerSerial;
}





  
  }