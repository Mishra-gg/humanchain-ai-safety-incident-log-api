package com.humanchain.incidents.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "incidents")
public class Incident {
	 @Id
	    private String id;
	    private String title;
	    private String description;
	    private String severity; // Allowed values: Low, Medium, High
	    private LocalDateTime reportedAt;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getSeverity() {
			return severity;
		}
		public void setSeverity(String severity) {
			this.severity = severity;
		}
		public LocalDateTime getReportedAt() {
			return reportedAt;
		}
		public void setReportedAt(LocalDateTime reportedAt) {
			this.reportedAt = reportedAt;
		}
		@Override
		public String toString() {
			return "Incident [id=" + id + ", title=" + title + ", description=" + description + ", severity=" + severity
					+ ", reportedAt=" + reportedAt + "]";
		}
	    

}
