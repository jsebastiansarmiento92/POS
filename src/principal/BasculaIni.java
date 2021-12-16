/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ventas.CajaAd;

/**
 *
 * @author jseba
 */
public class BasculaIni {
        CommPortIdentifier portId;
	Enumeration puertos;
	SerialPort serialport;
	static InputStream entrada = null;
	Thread t;
        private String peso="";
	//private String puertoCom="";
	private boolean estadoPuertos=true;
	//private ListaAlimentosAd productosAd;
	private LeerSerial leerSerial;
        int aux; String pesoFin="";
       // CommPortIdentifier puertoidFijo;
        private CajaAd cajaAd;
        
        public BasculaIni() {
		// TODO Auto-generated constructor stub
    
    	//iniLectura();
        //lecturaFija();
	}

    public BasculaIni(CajaAd cajaAd) {
        System.out.println("principal.BasculaIni.<init>()");
        this.cajaAd=cajaAd;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public String lecturaFija(){
          puertos=CommPortIdentifier.getPortIdentifiers();
    	  this.leerSerial=new LeerSerial(peso);
          System.err.println("el valor de variable peso es: ");
          System.err.println(peso);
          t = new Thread(leerSerial);
        
        while (puertos.hasMoreElements()&&estadoPuertos) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar 
        	//hasmorelements mientras tenga mas eleementos
        	portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorre uno por uno
                System.out.println("puerto id " + portId.getName());
        	//System.out.println(portId.getName()); //puertos disponbibles
                
        	if (portId.getName().equalsIgnoreCase(portId.getName())) {
        		try {
        		serialport= (SerialPort)portId.open("LecturaSerial", 2);//tiempo en ms
                         System.out.println("serialport  "+serialport);
    				entrada = serialport.getInputStream();//esta variable del tipo InputStream obtiene el dato serial
                              //  System.out.println("entrada    "+ entrada.read());
   				//System.out.println("entrada    "+ entrada.toString());
                                
                               // System.err.println("entrada.read()"+entrada.read());
                                int aux2;
                                for (int i = 0; i < 100; i++) {
                                    aux2=aux;
                                    aux=entrada.read();
                                  //System.out.println();
                                    System.out.println("(char)aux: "+(char)aux+" :"+"aux: "+ aux+" :");
                                   if (aux>0) {
  					if (((char)aux<58)&&((char)aux>45)||(char)aux==13||(char)aux==10) {
  						System.out.println("aux: "+aux+" aux2: "+aux2);
  						if (aux==13) {
  							pesoFin=peso;
  							System.out.println(pesoFin+" peso final "+peso);
                                                        
  							//basculaFrame.getLabelValor().setText(pesoFin);
  							peso="";
                                                        estadoPuertos=false;
                                                        
                                                        break;
                                                        
 						}else
                                                
  						//System.out.println("lo que deberia salir :"+(char)aux);//imprimimos el dato serial
  						peso+=(char)aux;
                                                
                                                
                                                
 					}
 				}
                            }
                                
                            //    while (true) {                                
                                  
                            }

  			 catch (Exception e) {
  			//	LecturaSerialRec();
  				System.out.println("error en el puerto");
                                JOptionPane.showMessageDialog(null, e.getMessage());
  				estadoPuertos=false;
  			} } }
  			System.out.println("sale de la lectura");
                        try {
                serialport.close();
                        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Bascula no responde o desconectada");
                
                return pesoFin;
            }
                        return pesoFin;
        }
        public String lecturaFijaSegundaBas(){
          puertos=CommPortIdentifier.getPortIdentifiers();
    	  this.leerSerial=new LeerSerial(peso);
          System.err.println("el valor de variable peso es: ");
          System.err.println(peso);
          t = new Thread(leerSerial);
        if(cajaAd.getPuertoidFijo()!=null){
            
        }else while (puertos.hasMoreElements()&&estadoPuertos) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar 
        	//hasmorelements mientras tenga mas eleementos
                
        	portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorre uno por uno
                System.out.println("puerto id " + portId.getName());
        	//System.out.println(portId.getName()); //puertos disponbibles
        	if (portId.getName().equalsIgnoreCase(portId.getName())) {
                    if(cajaAd.getPuertoidFijo().getName().equalsIgnoreCase("COM3")){
                        return returnValor(cajaAd.getPuertoidFijo());
                    }
                        
        		try {
        		serialport= (SerialPort)portId.open("LecturaSerial", 2);//tiempo en ms
                         System.out.println("serialport  "+serialport);
    				entrada = serialport.getInputStream();//esta variable del tipo InputStream obtiene el dato serial
                             System.out.println("entrada    "+ entrada.read());
   				System.out.println("entrada    "+ entrada);
                                for (int i = 0; i < 100; i++) {
                                    aux=entrada.read();
                                  System.out.println("principal.BasculaIni.lecturaFija()"+ aux);
                                   if (aux>0) {
  					if (((char)aux<58)&&((char)aux>45)||(char)aux==103) {
  						
  						if (aux==103) {
  							pesoFin=peso;
  							System.out.println(pesoFin+" peso final "+peso);
                                                        
  							//basculaFrame.getLabelValor().setText(pesoFin);
  							peso="";
                                                        estadoPuertos=false;
                                                        
                                                        break;
                                                        
 						}else
  						System.out.print("lo que deberia salir :"+((char)aux)+"peso : "+peso);//imprimimos el dato serial
                                                if(peso.length()>6){
                                                    pesoFin=peso;
                                                    serialport.close();
                                                    peso="";
                                                    
                                                    return pesoFin ;
                                                    
                                                    
                                                }else
  						peso+=(char)aux;
 					}
 				}
                            }
                                
                            //    while (true) {                                
                                  
                            }

  			 catch (Exception e) {
  			//	LecturaSerialRec();
  				System.out.println("error en el puerto");
                                JOptionPane.showMessageDialog(null, e.getMessage());
  				estadoPuertos=false;
  			} } }
  			System.out.println("sale de la lectura");
                        try {
                serialport.close();
                        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Bascula no responde o desconectada");
                
                return pesoFin;
            }
                        return pesoFin;
        }
        public String returnValor(CommPortIdentifier portId){
            try {
        		serialport= (SerialPort)portId.open("LecturaSerial", 2);//tiempo en ms
                         System.out.println("serialport  "+serialport);
    				entrada = serialport.getInputStream();//esta variable del tipo InputStream obtiene el dato serial
                             System.out.println("entrada    "+ entrada.read());
   				System.out.println("entrada    "+ entrada);
                                for (int i = 0; i < 100; i++) {
                                    aux=entrada.read();
                                  System.out.println("principal.BasculaIni.lecturaFija()"+ aux);
                                   if (aux>0) {
  					if (((char)aux<58)&&((char)aux>45)||(char)aux==103) {
  						
  						if (aux==103) {
  							pesoFin=peso;
  							System.out.println(pesoFin+" peso final "+peso);
                                                        
  							//basculaFrame.getLabelValor().setText(pesoFin);
  							peso="";
                                                        estadoPuertos=false;
                                                        
                                                        break;
                                                        
 						}else
  						System.out.print("lo que deberia salir :"+((char)aux)+"peso : "+peso);//imprimimos el dato serial
                                                if(peso.length()>6){
                                                    pesoFin=peso;
                                                    serialport.close();
                                                    peso="";
                                                    
                                                    return pesoFin ;
                                                    
                                                    
                                                }else
  						peso+=(char)aux;
 					}
 				}
                            }
                                
                            //    while (true) {                                
                                  
                            } catch (Exception e) {
  			//	LecturaSerialRec();
  				System.out.println("error en el puerto");
                                JOptionPane.showMessageDialog(null, e.getMessage());
  				estadoPuertos=false;
  			} 
            return null ;
        }
        public void iniLectura() {

    	  puertos=CommPortIdentifier.getPortIdentifiers();
    	  this.leerSerial=new LeerSerial(peso);
          t = new Thread(leerSerial);
        
        while (puertos.hasMoreElements()&&estadoPuertos) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar 
        	//hasmorelements mientras tenga mas eleementos
        	portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorre uno por uno
                System.out.println("puerto id " + portId.getName());
        	//System.out.println(portId.getName()); //puertos disponbibles
        	if (portId.getName().equalsIgnoreCase(portId.getName())) {
        		try {
        		serialport= (SerialPort)portId.open("LecturaSerial", 2);//tiempo en ms
                         System.out.println("serialport  "+serialport);
    				entrada = serialport.getInputStream();//esta variable del tipo InputStream obtiene el dato serial
                                System.out.println("entrada "+ entrada.read());
   				t.start(); // inciamos el hilo para realizar nuestra accion de imprimir el dato serial
     		 
  			} catch (Exception e) {
  			//	LecturaSerialRec();
  				System.out.println("error en el puerto");
  				estadoPuertos=false;
  			} } }
        
    
    }

    public Thread getT() {
        return t;
    }
        
     public static class LeerSerial implements Runnable{


 	   int aux;
 	   boolean estadoHilo=true;
 	   private String peso="";
 	   String pesoFin="";
 	//   private BasculaFrame basculaFrame;
        public LeerSerial(String peso) {
            this.peso=peso;
        	run();
        	//this.basculaFrame=basculaFrame;
		// TODO Auto-generated constructor stub
	}
		public void run () {
                  while(estadoHilo){
     		  try {
 				aux = BasculaIni.entrada.read(); // aqui estamos obteniendo nuestro dato serial
 				Thread.sleep(10);
  				if (aux>0) {
  					if (((char)aux<58)&&((char)aux>45)||(char)aux==103) {
  						
  						if (aux==103) {
  						
  							pesoFin=peso;
  							System.out.println(pesoFin);
  							//basculaFrame.getLabelValor().setText(pesoFin);
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
   	
    }   
      public static void main(String args[]) {
      
        
            
       BasculaIni basculaIni =  new  BasculaIni();
     // System.out.println("peso "+basculaIni.lecturaFijaSegundaBascula());
      
      System.out.print("valor     "+basculaIni.getPeso());

           
    }

    public String getPeso() {
        return peso;
    }
      
}


