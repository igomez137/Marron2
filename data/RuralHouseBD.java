package data;
import java.util.Date;
import java.util.List;   

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.Offer;
import domain.RuralHouse;
public class RuralHouseBD {

	private EntityManager db;
	private EntityManagerFactory emf;
	String fileName= "Casas_Rurales.odb";
	
	public RuralHouseBD(){
		
		emf=Persistence.createEntityManagerFactory("objectdb:" + fileName);
		db = emf.createEntityManager();
		System.out.println("Base de datos abierta: "+ fileName);
	}
	public void close(){
		db.close();
		System.out.println("Base de datos cerrada: " + fileName);
	}
	
	//A�adir una nueva casa rural a la base de datos
	public RuralHouse insertarCasa(String city,String address,int n){
		db.getTransaction().begin();
		RuralHouse rh = new RuralHouse(city,address,n);
		db.persist(rh);
		db.getTransaction().commit();
		System.out.println("Insertado:" + rh);
		return rh;
	}
	
	/*
	 * Metodo que permite adquirir
	 * una casa en cuestion por su ciudad.
	 */
	public List<RuralHouse> cogerCasaCiudad(String ciudad){
		TypedQuery<RuralHouse> query =
				db.createQuery("SELECT p FROM RuralHouse p WHERE p.city='"+ciudad+"'",RuralHouse.class);
		List<RuralHouse> rh = query.getResultList();
		System.out.println("Contenido de la base de datos:");
		for(RuralHouse p:rh) System.out.println(p.toString());
		return rh;
	}
	/*
	 * Metodo que permite adquirir
	 * una casa en cuestion por su ciudad.
	 */
	public RuralHouse cogerCasaId(int id){
		TypedQuery<RuralHouse> query =
				db.createQuery("SELECT p FROM RuralHouse p WHERE p.houseNumber="+id,RuralHouse.class);
	
		RuralHouse rh = query.getSingleResult();
		
		System.out.print("Contenido de la base de datos: " + rh.toString());
		
		return rh;
	}
	public void borrarCasas(){
		TypedQuery<RuralHouse> query =
				db.createQuery("DELETE rh FROM RuralHouse rh" ,RuralHouse.class);
		int casasEliminadas=query.executeUpdate();
		System.out.println("Ofertas eliminadas: " + casasEliminadas);
	}
	public List<RuralHouse> todasCasas(){
		TypedQuery<RuralHouse> query =
				db.createQuery("SELECT rh FROM RuralHouse rh", RuralHouse.class);
		List<RuralHouse> rh = query.getResultList();
		System.out.println("Contenido de la base de datos:");
		for(RuralHouse r: rh) System.out.println(r.toString());
		return rh;
	}
	public void verOfertas (RuralHouse rb){
		List<Offer> of = (List<Offer>) rb.getOffers();
		for (Offer o : of){
			System.out.println(o.toString());
		}
	}
	public void insertaNOferta(Date date, int tripleNumber, int doubleNumber, int singleNumber,RuralHouse rh){
		db.getTransaction().begin();
		Offer of = new Offer(date,tripleNumber,doubleNumber,singleNumber,rh);
		rh.add(of);
		db.persist(of);
		db.getTransaction().commit();
		System.out.println("Insertado:" + of);
	}
	public void setHabitacion(Offer idO, int valor){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("idO.getID: "+idO.getId());
            Offer o=db.find(Offer.class, idO.getId());
            System.out.println("o.getID: "+o.getId());
            db.getTransaction().begin();
            int anterior=0;
            switch(valor){
            case 1:
                {            
                System.out.println("o.getsingleNumber: "+o.getSingleNumber());
                anterior=idO.getSingleNumber();
                o.setSingleNumber(anterior-1);
                System.out.println("o.getSingleNumber(): "+o.getSingleNumber());
                System.out.println("Numero de habitacion single: " + o.getSingleNumber());
                break;}
            case 2:
                {anterior=idO.getDoubleNumber();
                idO.setDoubleNumber(anterior-1);
                System.out.println("Numero de habitacion doble:" + idO.getDoubleNumber());
                break;}
            case 3:
                {anterior=idO.getTripleNumber();
                idO.setTripleNumber(anterior-1);
                System.out.println("Numero de habitacion triple:" + idO.getTripleNumber());
                break;}
            default:
                System.out.println("Ha existido un error");
                break;
            }
            db.getTransaction().commit();
            o=db.find(Offer.class, idO.getId());
            System.out.println("o.toString"+o.toString());
            System.out.println("Modificado:" + o.toString());
	}
        
        public Offer CogerOferta(int ID){
        Offer o =db.find(Offer.class, ID);
        return o;
        }
}

