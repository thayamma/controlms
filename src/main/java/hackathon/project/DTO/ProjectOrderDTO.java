package hackathon.project.DTO;


import java.util.Optional;

import hackathon.project.Entity.ProjectOrderEntity;

public class ProjectOrderDTO {
	int orderid;
	String quotationmodelno;
	String customerid;
	String customername;
	String price;
	String email;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getQuotationmodelno() {
		return quotationmodelno;
	}
	public void setQuotationmodelno(String quotationmodelno) {
		this.quotationmodelno = quotationmodelno;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public ProjectOrderEntity createEntity(ProjectDTO p1) {
		ProjectOrderEntity entity= new ProjectOrderEntity();
		entity.setCustomerid(this.customerid);
		entity.setCustomername(this.customername);
		entity.setEmail(this.email);
		entity.setPrice(p1.getCost());
		entity.setQuotationmodelno(this.quotationmodelno);
		return entity;
	}
	public static ProjectOrderDTO value(ProjectOrderEntity en) {
		ProjectOrderDTO orderdto=new ProjectOrderDTO();
		orderdto.setCustomerid(en.getCustomerid());
		orderdto.setCustomername(en.getCustomername());
		orderdto.setEmail(en.getEmail());
		orderdto.setOrderid(en.getOrderid());
		orderdto.setPrice(en.getPrice());
		orderdto.setQuotationmodelno(en.getQuotationmodelno());
		return orderdto;
	}
	public static ProjectOrderDTO valueOf(Optional<ProjectOrderEntity> entity) {
		ProjectOrderDTO orderdto=new ProjectOrderDTO();
		orderdto.setCustomerid(entity.get().getCustomerid());
		orderdto.setCustomername(entity.get().getCustomername());
		orderdto.setEmail(entity.get().getEmail());
		orderdto.setOrderid(entity.get().getOrderid());
		orderdto.setPrice(entity.get().getPrice());
		orderdto.setQuotationmodelno(entity.get().getQuotationmodelno());
		return orderdto;
	}

}
