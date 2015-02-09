package com.jesry.sample;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import d3.data.TPS.TPS;
import d3.data.db.DBConnection;



@Path("/tps")
public class Rest {
	
	@Path("{c}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TPS> getTpsCount(@PathParam("c") String c) throws SQLException
	{
		
		System.out.println("Started..."+c);
		c = c.replace("-", "/");
		List<TPS> list = new ArrayList();
		
		/*TPS tps = new TPS(c, 634);
		list.add(tps);*/
		
		DBConnection connection = new DBConnection();
        Connection con = connection.getConnection();
        Statement stmt = con.createStatement();
        String sql = "select cdrgenerationdate , count(*) as sessionstarts from cdrs where transactiontype = 1 and cdrgenerationdate= '"+c+"' group by cdrgenerationdate";
        ResultSet res = stmt.executeQuery(sql);
        if(res == null)
        {
        	System.out.println("IN NULL");
        	TPS tps = new TPS(c, 0);
            list.add(tps);
        }else{
        	System.out.println("IN ELSE");
        while (res.next()) {
          TPS tps = new TPS(res.getString(1), Long.parseLong(res.getString(2)));
          list.add(tps);
        }
        
        }
		
		
		System.out.println("Done..."+c);
		return list;
		
		
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TPS> getTpsCount() throws SQLException
	{
		System.out.println("Started.......");
		List<TPS> list = new ArrayList();
		/*list.add(new TPS("1/1/2015", 645));
		list.add(new TPS("2/1/2015", 535));
		list.add(new TPS("3/1/2015", 715));
		list.add(new TPS("5/1/2015", 675));*/
		
		DBConnection connection = new DBConnection();
        Connection con = connection.getConnection();
        Statement stmt = con.createStatement();
        String sql = "select cdrgenerationdate , count(*) as sessionstarts from cdrs where transactiontype = 1 group by cdrgenerationdate order by cdrgenerationdate asc";
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
          TPS tps = new TPS(res.getString(1), Long.parseLong(res.getString(2)));
          list.add(tps);
        }
		
		
		System.out.println("Done...");
		return list;
	}
}