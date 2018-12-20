package casestudy;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;



import aj.org.objectweb.asm.Type;
import casestudy.entity.Product;

public 
 class StringPrefixedSequenceIdGenerator implements IdentifierGenerator{
	

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		Product p = new Product();
		 String productid=null;
		Connection connection = session.connection();
		try {
			String query= "select * from product_master where product_type = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			 statement.setString(1, p.getProductType());
			ResultSet rs= statement.executeQuery();
			 
			
			int count=0;
			while(rs.next())
			{
			count ++;
			}
			String prod ="H";
		  productid = prod.concat(String.format("%04d", count));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return productid;
	}

	

	
}	
