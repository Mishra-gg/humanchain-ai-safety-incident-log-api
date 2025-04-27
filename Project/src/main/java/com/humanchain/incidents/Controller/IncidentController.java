package com.humanchain.incidents.Controller;

import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humanchain.incidents.Model.Incident;
import com.humanchain.incidents.Service.IncidentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/incidents")

public class IncidentController 
{
	
	private final IncidentService incidentService;
	public IncidentController(IncidentService incidentService)
	{
		this.incidentService=incidentService;
	}
	@GetMapping
	public ResponseEntity<List<Incident>> getAllIncident()
	{
	
		return ResponseEntity.ok(incidentService.getAllIncident());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Incident> getIncidentById(@PathVariable String id)
	{
		try
		{
			Incident incident=incidentService.getIncidentById(id);
			return ResponseEntity.status(HttpStatus.OK).body(incident);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PostMapping
	public ResponseEntity<Incident> createIncident(@Valid @RequestBody Incident incident)
	{
		if(!"Low".equalsIgnoreCase(incident.getSeverity()) && !"Medium".equalsIgnoreCase(incident.getSeverity()) && !"High".equalsIgnoreCase(incident.getSeverity()))
		{
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			Incident savedIncident=incidentService.createIncident(incident);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedIncident);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id)
	{
		try
		{
			incidentService.deleteIncident(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
	
	
