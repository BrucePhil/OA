package com.direct.action;



import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.direct.Dao.DBHelper;
import com.direct.entity.Department;
import com.direct.entity.Job;
import com.direct.entity.Positiontype;
import com.direct.entity.Postgrade;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

public class action {
//	映射job对象
	private Job j;
	
public Job getJ() {
		return j;
	}

	public void setJ(Job j) {
		this.j = j;
	}
//	映射删除修改job的id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//	映射dep对象
	private Department de;

	public Department getDe() {
		return de;
	}

	public void setDe(Department de) {
		this.de = de;
	}
	
//	映射posit对象
	private Positiontype po;
	public Positiontype getPo() {
		return po;
	}

	public void setPo(Positiontype po) {
		this.po = po;
	}
	
//	映射postgrade对象
	private Postgrade pg;
	public Postgrade getPg() {
		return pg;
	}

	public void setPg(Postgrade pg) {
		this.pg = pg;
	}
	
	
	

	//	添加职务
	public String addjob(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.addjob(j)){
			return queryjob();
		}
		return "errorjob";
	}
	
//	查询职务
	public String queryjob(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Job> arr=db.query_job();
		if(arr.size()>0){
			ActionContext.getContext().getSession().put("job",arr );
		
		return"job";
		}
		return"";
	}
	
//	删除职务
	public String deljob(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		db.del_job(getId());
		return queryjob();
		
	}
	
//	查询职务id
	public String queryjobid(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Job> arr=db.queryjobid(getId());
		if(arr.size()>0){
		for(int i=0;i<arr.size();i++){
			Job j=arr.get(i);
			ActionContext.getContext().getSession().put("id", j.getJobId());
			ActionContext.getContext().getSession().put("name", j.getJobName());
		}
			return "updatejobid";
		}else{
			return "job";
		}
		
	}
	
//	修改职务
	public String updatejob(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.updatejob(j)){
			return queryjob();
		}else{
			return "updatejob";
		}
	}
	
//	添加部门信息
	public String adddep(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.adddep(de)){
			return querydep();
		}else{
			return "errordep";
		}
	}
	
	
//	查询部门信息
	public String querydep(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Department>arr=db.query_dep();
		if(arr.size()>0){
			ActionContext.getContext().getSession().put("dep", arr);
			return "adddep";
		}else{
			return "";
		}
	}
	
//	id查询部门
	public String querydepid(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Department> arr=db.query_depid(getId());
		if(arr.size()>0){
			Department de=arr.get(0);
			ActionContext.getContext().getSession().put("dep", de);
			return "querydepid";
		}
		return "adddep";
	}
	
	
//	删除部门
	public String deldep(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		db.del_dep(getId());
		return querydep();
		
	}
	
//	修改部门
	public String updatedep(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.updatedep(de)){
			return querydep();
		}
		return "updatedep";
	}
	
	
//	添加职位类型
	public String addposit(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.addposit(po)){
			return queryposit();
		}
		return "errorjob";
	}
	
//	查询职位类型
	public String queryposit(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Positiontype> arr=db.query_posit();
		if(arr.size()>0){
			ActionContext.getContext().getSession().put("po",arr );
		
		return"addposit";
		}
		return"";
	}
	
//	删除职位类型
	public String delposit(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		db.del_posit(getId());
		return queryposit();
	}
	
//	查询职位类型id
	public String querpoitid(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Positiontype> arr=db.query_positid(getId());
		if(arr.size()>0){
			for(int i=0;i<arr.size();i++){
				Positiontype po=arr.get(i);
				ActionContext.getContext().getSession().put("po", po);
				return "querpoitid";
			}
		}
		return "addposit";
	}
	
//	修改职位类型
	public String updateposit(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.updateposit(po)){
			return queryposit();
		}
		return "querpoitid";
	}
	
//	添加岗级
	public String addpostgrade(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.addpostgrade(pg)){
			return querypostgrade();
		} 
		return "errorpost";
	}
	
//	查询岗级
	public String querypostgrade(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Postgrade> arr=db.query_postgrade();
		if(arr.size()>0){
			ActionContext.getContext().getSession().put("pg",arr );
		
		return"addpost";
		}
		return"";
	}
	
	
//	删除岗级
	public String delpostgrade(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		db.del_postgrade(getId());
		return querypostgrade();
	}
	
	
//	查询岗级id
	public String querpostgradeid(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		ArrayList<Postgrade> arr=db.query_postgradeid(getId());
		if(arr.size()>0){
			for(int i=0;i<arr.size();i++){
				Postgrade pg=arr.get(i);
				ActionContext.getContext().getSession().put("pg", pg);
				return "querpostgradeid";
			}
		}
		return "addpost";
	}
//删除岗级	
	public String updatepostgrade(){
		BeanFactory be=new ClassPathXmlApplicationContext("applicationContext.xml");
		DBHelper db=be.getBean(DBHelper.class);
		if(db.updatepostgrade(pg)){
			return querypostgrade();
		}
		return "querpostgradeid";
	}

}
