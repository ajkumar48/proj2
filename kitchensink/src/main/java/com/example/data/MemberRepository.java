package com.example.data;

//Class to implement data queries 
import com.example.model.Member;


import java.util.* ;
import org.hibernate.Session; 
import org.springframework.stereotype.Service;

@Service
public class MemberRepository
{
	
    public Member findById(Long id) 
    {
    	//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		
		//int id=1 ;
		Member member1 = (Member) session.get(Member.class, id);
		System.out.println("Member ID=" +  member1.getId() + " " + member1.getName()  );

		//emp.setName(  "Ajay" );
		//session.update(emp);
		//List<Object> stlist  =  session.createSQLQuery("select * from Employee").list();
		//System.out.println("stlist size=" +  stlist.size()  );

		//session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		//System.out.println("Employee ID="+member1.getId());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();

    	
        return member1 ;
    }

	
	public List<Member> findAllOrderedByName()
	{
		
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		
		//int id=1 ;
		//Employee emp = (Employee) session.get(Employee.class, id);
		System.out.println( "findAllOrderedByName:" + "Step 1"  );

		//emp.setName(  "Ajay" );
		
		//session.update(emp);
		List<Object[]> stlist  =  session.createSQLQuery("select * from members").list();
		System.out.println("stlist size=" +  stlist.size()  );

		//session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		//System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
		List<Member> result = new Vector<Member>() ;
		for( Object[] arr1 : stlist )
		  //for( int i1=0 ; i1< arr1.length ; i1++ )
		  {
			Long id = Long.valueOf( ((Integer) arr1[0]).longValue()  ); ;
			String name = (String) arr1[1] ;
			String email = (String) arr1[2] ;
			String phoneNumber = (String) arr1[3] ;
			Member member1 = new Member(id,name,email, phoneNumber) ;
			System.out.println( member1 ) ;
			result.add( member1 )  ;
		  }
			 // System.out.println(   (String) arr1[i1] ) ; 
		  //result.add( (Member)obj1  )  ;
		
		return result ; 
	}
	
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
