package main;

import java.awt.print.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Function {

	public void addBook(String ISBN,String name,String author,String edition){
		
		String sql="" +
		"insert into Booklist" +
		"(ISBN,name,author,edition)" values (?,?,?,?)";	
	
		PreparedStatement ptmt=conn.PrepareStatement(sql);  // throws Exception
		ptmt.setString(1, ISBN);
		ptmt.setString(2, name);
		ptmt.setString(3, author);
		ptmt.setString(4, edition);
		ptmt.execute();
	}
	
	public void delBook(String ISBN){
		String sql="" +
	            "delete from Booklist" +
				"where ISBN=?";
		PreparedStatement ptmt=conn.PrepareStatement(sql);
		ptmt.setString(1, ISBN);
		ptmt.execute();
	}
	
	public Book query(String ISBN){
		Book g=null;
		String sql="" +
	            "select * from Booklist" +
				"where ISBN=?";
		PreparedStatement ptmt=conn.PrepareStatement(sql);
		ptmt.setString(1, ISBN);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			g=new Book();
			g.SetISBN(rs.getString("ISBN"));
			g.Setname(rs.getString("name"));
			g.Setauthor(rs.getString("author"));
			g.Setedition(rs.getString("edition"));
			
		}
		return null;
	}
}