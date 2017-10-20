package com.direct.Dao;

import java.util.ArrayList;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.direct.entity.Department;
import com.direct.entity.Job;
import com.direct.entity.Positiontype;
import com.direct.entity.Postgrade;
import com.direct.entity.Userinfo;
import com.opensymphony.xwork2.ActionSupport;

public class DBHelper extends ActionSupport{
	public Session getsession(){
		Configuration cf=new AnnotationConfiguration();
		cf.configure("hibernate.cfg.xml");
		SessionFactory sf=cf.buildSessionFactory();
		Session se=sf.openSession();
		return se;
	}
	
//	添加职务
	public boolean addjob(Job jo){
		Session se=getsession();
		jo.setJobName(jo.getJobName());
		se.save(jo);
		Transaction tran=se.beginTransaction();
		tran.commit();
		se.close();
		return true;
		
	}
	
//	查询职务
	public ArrayList<Job> query_job(){
		Session se=getsession();
		String hql="from Job";
		Query qu=se.createQuery(hql);
		ArrayList<Job> jo=(ArrayList<Job>) qu.list();
		return jo;
	}
	
//	删除职务
	public boolean del_job(int id){
		Session se=getsession();
		String hql="delete Job where jobId="+id+"";
		Transaction tran=se.beginTransaction();
		Query qu=se.createQuery(hql);
		int i=qu.executeUpdate();
		tran.commit();
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	
//	查询职务id
	public ArrayList<Job> queryjobid(int id){
		Session se=getsession();
		String hql="from Job where jobId="+id+"";
		Query qu=se.createQuery(hql);
		ArrayList<Job> j=(ArrayList<Job>) qu.list();
		return j;
		
	}
	
//	修改职务
	public boolean updatejob(Job j){
		Session se=getsession();
		String hql="update Job set jobName='"+j.getJobName()+"' where jobId="+j.getJobId()+"";
		Transaction tran=se.beginTransaction();
		Query qu=se.createQuery(hql);
		int i=qu.executeUpdate();
		tran.commit();
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
//	添加部门
	public boolean adddep(Department de){
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		Userinfo ui=app.getBean(Userinfo.class);
		Session se=getsession();
		de.setDepName(de.getDepName());
//		判断领导人是否为空
		if(de.getUserinfo().getId()==0){
			de.setUserinfo(null);
		}else{
			ui.setId(de.getUserinfo().getId());
			de.setUserinfo(ui);
		}
		de.setDepRemak(de.getDepRemak());
		se.save(de);
		Transaction tran=se.beginTransaction();
		tran.commit();
		se.close();
		return true;
		
	}
	
//	查询部门
	public ArrayList<Department> query_dep(){
		Session se=getsession();
		String hql="from Department";
		Query qu=se.createQuery(hql);
		ArrayList<Department> de=(ArrayList<Department>) qu.list();
		return de;
	}
	
//	通过id查询部门id
	public ArrayList<Department> query_depid(int id){
		Session se=getsession();
		String hql="from Department where depId="+id+"";
		Query qu=se.createQuery(hql);
		ArrayList<Department> de=(ArrayList<Department>) qu.list();
		return de;
	}
	
//	删除部门
	public boolean del_dep(int id){
		Session se=getsession();
		String hql="delete Department where depId="+id+"";
		Transaction tran=se.beginTransaction();
		Query qu=se.createQuery(hql);
		int i=qu.executeUpdate();
		tran.commit();
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
//	修改部门
	public Boolean updatedep(Department de){
		try {
			Session se=getsession();
//			Userinfo usi=new Userinfo();
//			usi.setId(1);
//			de.setUserinfo(usi);
			String hql="update Department set depName='"+de.getDepName()+"',userinfo="+de.getUserinfo().getId()+",depRemak='"+de.getDepRemak()+"'where depId="+de.getDepId()+"";
			Transaction tran=se.beginTransaction();
			Query qu=se.createQuery(hql);
			int i=qu.executeUpdate();
			tran.commit();
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}
		
		
		return false;
	}
	
	
//	添加职位类型
	public boolean addposit(Positiontype po){
		Session se=getsession();
		po.setPositionTypeName(po.getPositionTypeName());
		se.save(po);
		Transaction tran=se.beginTransaction();
		tran.commit();
		se.close();
		return true;
		
	}
	
//	查询职位类型
	public ArrayList<Positiontype> query_posit(){
		Session se=getsession();
		String hql="from Positiontype";
		Query qu=se.createQuery(hql);
		ArrayList<Positiontype> po=(ArrayList<Positiontype>) qu.list();
		return po;
	}
	
	
//	删除职位类型
	public boolean del_posit(int id){
		Session se=getsession();
		String hql="delete Positiontype where positionTypeId="+id+"";
		Transaction tran=se.beginTransaction();
		Query qu=se.createQuery(hql);
		int i=qu.executeUpdate();
		tran.commit();
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	
//	查询职位类型id
	public ArrayList<Positiontype> query_positid(int id){
		Session se=getsession();
		String hql="from Positiontype where positionTypeId="+id+"";
		Query qu=se.createQuery(hql);
		ArrayList<Positiontype>po= (ArrayList<Positiontype>) qu.list();
		return po;
	}
	
//	修改职位类型
	public boolean updateposit(Positiontype po){
		Session se=getsession();
		String hql="update Positiontype set positionTypeName='"+po.getPositionTypeName()+"' where positionTypeId="+po.getPositionTypeId()+"";
		Transaction tran=se.beginTransaction();
		Query qu=se.createQuery(hql);
		int i=qu.executeUpdate();
		tran.commit();
		if(i>0){
			return true;
		}
		return false;
	}
	
//	添加岗级
	public boolean addpostgrade(Postgrade pg){
		Session se=getsession();
		pg.setPgname(pg.getPgname());
		se.save(pg);
		Transaction tran=se.beginTransaction();
		tran.commit();
		se.close();
		return true;
		
	}
	
//	查询岗级
	public ArrayList<Postgrade> query_postgrade(){
		Session se=getsession();
		String hql="from Postgrade";
		Query qu=se.createQuery(hql);
		ArrayList<Postgrade> pg=(ArrayList<Postgrade>) qu.list();
		return pg;
	}
	
//	删除岗级
	public boolean del_postgrade(int id){
		Session se=getsession();
		String hql="delete Postgrade where pgid="+id+"";
		Transaction tran=se.beginTransaction();
		Query qu=se.createQuery(hql);
		int i=qu.executeUpdate();
		tran.commit();
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	
//	查询岗级id
	public ArrayList<Postgrade> query_postgradeid(int id){
		Session se=getsession();
		String hql="from Postgrade where pgid="+id+"";
		Query qu=se.createQuery(hql);
		ArrayList<Postgrade>pg= (ArrayList<Postgrade>) qu.list();
		return pg;
	}
	
//	修改岗级
	public boolean updatepostgrade(Postgrade pg){
		Session se=getsession();
		String hql="update Postgrade set pgname='"+pg.getPgname()+"' where pgid="+pg.getPgid()+"";
		Transaction tran=se.beginTransaction();
		Query qu=se.createQuery(hql);
		int i=qu.executeUpdate();
		tran.commit();
		if(i>0){
			return true;
		}
		return false;
	}
	
}
