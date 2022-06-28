package org.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.setCar_name("Maruthi");
		c1.setCar_model("Alto");
		c1.setCar_color("Blue");
		
		
		Car c2 = new Car();
		c2.setCar_name("Tata");
		c2.setCar_model("Nano");
		c2.setCar_color("Black");
		
		Car c3 = new Car();
		c3.setCar_name("Maruthi");
		c3.setCar_model("Swift");
		c3.setCar_color("Red");
		
		List<Car> carlist = new ArrayList<>();
        carlist.add(c1);
        carlist.add(c2);
        carlist.add(c3);
		
		Person p = new Person();
		p.setP_name("Harshata");
		p.setCars(carlist);
		
		
		Configuration con = new Configuration();
		con.configure();		
		
		SessionFactory sef = con.buildSessionFactory();
		Session ses = sef.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(c1);
		ses.save(c2);
		ses.save(c3);
	    ses.save(p);
	    tr.commit();
	    ses.close();
	}

}
