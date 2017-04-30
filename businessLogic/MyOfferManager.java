package businessLogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import data.*;
import domain.*;


@WebService(endpointInterface = "businessLogic.OfferManager")
public class MyOfferManager implements OfferManager{
//ArrayList<RuralHouse> ruralHousessDB;

	private RuralHouseBD rhB;
	
	Collection<Offer> res;
	
public MyOfferManager () {
	rhB = new RuralHouseBD();
	//ruralHousessDB = new ArrayList<RuralHouse>();
	try{
	RuralHouse rh1 = rhB.insertarCasa("Donostia","Avenida, 7", 6);

	rhB.insertaNOferta(newDate(2017,1,1),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,2),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,3),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,2),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,4),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,5),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,6),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,7),3,3,0,rh1);
	rhB.insertaNOferta(newDate(2017,1,8),0,0,3,rh1);
	rhB.insertaNOferta(newDate(2017,1,9),0,0,3,rh1);
	rhB.insertaNOferta(newDate(2017,1,10),0,0,3,rh1);
	rhB.insertaNOferta(newDate(2017,1,11),0,0,3,rh1);
	rhB.insertaNOferta(newDate(2017,1,12),0,1,3,rh1);
	rhB.insertaNOferta(newDate(2017,1,13),1,1,1,rh1);
	rhB.insertaNOferta(newDate(2017,1,14),0,1,3,rh1);
	rhB.verOfertas(rh1);
	
	//RuralHouse rh2 = new RuralHouse("Donostia","San Martin, 13");
	
	rhB.insertarCasa("Donostia", "San Martin, 13",2);
	RuralHouse rh2= rhB.cogerCasaId(2);
	rhB.insertaNOferta(newDate(2017,1,2),1,1,1,rh2);
		
	//RuralHouse rh3 = new RuralHouse("Bilbo","Zabalburu, 6");
	
	rhB.insertarCasa("Donostia", "San Martin, 13",3);
	RuralHouse rh3= rhB.cogerCasaId(3);
	rhB.insertaNOferta(newDate(2017,1,1),1,1,1,rh3);
	rhB.insertaNOferta(newDate(2017,1,2),0,1,0,rh3);
	rhB.insertaNOferta(newDate(2017,1,3),1,0,1,rh3);		
	}catch(Exception e){
		System.out.println("Cambiar datos:" +e.getMessage());
	}
	rhB.close();
	
}
		@WebMethod
		public Collection<Offer> getConcreteOffers(String city, Date date) {
				rhB = new data.RuralHouseBD();
				ArrayList<Offer> res = new ArrayList<Offer>();
				ArrayList<RuralHouse> rhBa = (ArrayList<RuralHouse>) rhB.todasCasas();
				for (RuralHouse rh : rhBa) 
					if ((rh.getCity().compareToIgnoreCase(city)==0))
						for (Offer off : rh.getOffers()) 
							if ((off.getDate().compareTo(date))==0) 
								res.add(off);
				rhB.close();
				return res;	
		}
		
		private Date newDate(int year,int month,int day) {

		     Calendar calendar = Calendar.getInstance();
		     calendar.set(year, month, day,0,0,0);
		     calendar.set(Calendar.MILLISECOND, 0);

		     return calendar.getTime();
		}
		  @WebMethod
		    @Override
		    public void ModHabi(int n, int hab){
		        rhB = new RuralHouseBD();
		        ArrayList<RuralHouse> rhBa = (ArrayList<RuralHouse>) rhB.todasCasas();
		        for (RuralHouse rh : rhBa) 
		            for (Offer off : rh.getOffers()) 
		                if ((off.getId())==n){
		                        rhB.setHabitacion(off, hab);
		                }

		        rhB.close();
		    }
		    @WebMethod

		    @Override
		    public void ElimiOferCasas(){
		        rhB = new RuralHouseBD();
		        rhB.borrarCasas();
		        rhB.close();

		    }
}