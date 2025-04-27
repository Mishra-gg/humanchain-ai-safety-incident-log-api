package com.humanchain.incidents.Service;



import java.util.List;

import com.humanchain.incidents.Model.Incident;

public interface IncidentService 
{
	
	List<Incident> getAllIncident();
	Incident getIncidentById(String id);
	Incident createIncident(Incident incident);
	void deleteIncident(String id);

}
