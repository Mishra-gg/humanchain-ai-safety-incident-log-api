package com.humanchain.incidents.Service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.humanchain.incidents.Model.Incident;
import com.humanchain.incidents.Repository_Interface.IncidentRepository;
import com.humanchain.incidents.Service.IncidentService;

@Service
public class IncidentServiceImpl implements IncidentService 
{
	private final IncidentRepository incidentRepository;
	public IncidentServiceImpl(IncidentRepository incidentRepository)
	{
		this.incidentRepository=incidentRepository;
				
	}
	@Override
	public List<Incident> getAllIncident()
	{
		return incidentRepository.findAll();
	}
	
	@Override
	public Incident getIncidentById(String id)
	{
		Optional<Incident> optionalIncident=incidentRepository.findById(id);
		if(optionalIncident.isPresent())
		{
			return optionalIncident.get();
		}
		else
		{
			throw new RuntimeException("Incident not found");
		}
	}
	@Override
	public Incident createIncident(Incident incident)
	{
		incident.setReportedAt(LocalDateTime.now());
		Incident savedIncident=incidentRepository.save(incident);
		
		return savedIncident;
	}
	@Override
	public void deleteIncident(String id)
	{
		if(!incidentRepository.existsById(id))
		{
			throw new RuntimeException("Incident Not Found!");
		}
		incidentRepository.deleteById(id);
	}
	
	

}
