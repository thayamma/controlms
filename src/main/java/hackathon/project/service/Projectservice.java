package hackathon.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hackathon.project.DTO.ProjectDTO;
import hackathon.project.DTO.ProjectOrderDTO;
import hackathon.project.Entity.ProjectEntity;
import hackathon.project.Entity.ProjectOrderEntity;
import hackathon.project.repository.ProjectOrderRepository;
import hackathon.project.repository.Projectrepository;

@Service
public class Projectservice {
	@Autowired
	Projectrepository repo;
	
	@Autowired
	ProjectOrderRepository orderrepo;
	
	public List<ProjectDTO> getmodel(){
		List<ProjectEntity> entity=repo.findAll();
		List<ProjectDTO> DTO=new ArrayList<ProjectDTO>();
		for(ProjectEntity e1:entity) {
			ProjectDTO d1=ProjectDTO.valueof(e1);
			DTO.add(d1);
		}
		return DTO;
		
	}
	
	public ProjectDTO getModelById(String manufactureModelNo) {
		ProjectDTO model= null;
		Optional<ProjectEntity> entity=repo.findById(manufactureModelNo);
		if(entity.isPresent()) {
			if(manufactureModelNo.equals(entity.get().getManufactureid())) {
				model=ProjectDTO.value(entity);
				}
		}
		return model;
	}
	
	public void order(ProjectOrderDTO order) throws Exception {
		Optional<ProjectEntity> entity=repo.findById(order.getQuotationmodelno());
		if(entity.isPresent()) {
			if(order.getQuotationmodelno().equals(entity.get().getManufactureid())) {
				ProjectDTO model=ProjectDTO.value(entity);
				ProjectOrderEntity Order= order.createEntity(model);
				orderrepo.save(Order);
			}
		}else {
			throw new Exception("Invalid Model Number");
		}
		
	}
	public void deleteOrder(Integer orderid) throws Exception {
		Optional<ProjectOrderEntity> entity= orderrepo.findById(orderid);
		if(entity.isPresent()) {
			orderrepo.deleteById(orderid);
		}else {
			throw new Exception("Order ID Unavailable");
		}
	}

	public List<ProjectOrderDTO> getvieworder() {
		List<ProjectOrderEntity> entity=orderrepo.findAll();
		List<ProjectOrderDTO> orderdto=new ArrayList<ProjectOrderDTO>();
		for(ProjectOrderEntity en:entity) {
			ProjectOrderDTO dto=ProjectOrderDTO.value(en);
			orderdto.add(dto);
		}
		
		return orderdto;
	}

	
	public ProjectOrderDTO getViewOrderById(Integer orderid) throws Exception {
		Optional<ProjectOrderEntity> entity= orderrepo.findById(orderid);
		if(entity.isPresent()) {
			ProjectOrderDTO projectOrderDTO = ProjectOrderDTO.valueOf(entity);
			return projectOrderDTO;
		}else {
			throw new Exception("Order ID Unavailable");
		}
		
	}

	


	
}
