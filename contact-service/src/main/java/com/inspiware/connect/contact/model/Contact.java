package com.inspiware.connect.contact.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Contact implements Serializable {

	private Long id;
	private Long organisationId;
	private String title;
	private String firstName;
	private String lastName;
	private String position;
	private String phone;
	private String email;
	private Boolean exEmployee;
	private String phone2;
	private String phone3;
	private LocalDateTime lastChecked;
	private Long authorityID;
	private Long productAreaID;
	private Long businessTypeID;
	private Boolean autoEmail;
	private String assistant;
	private String assistantEmail;
	private String assistantPhone;
	private Long contactFrequencyID;
	private Long personalUserID;
	private Long sourceID;
	private Long bossID;
	private LocalDateTime createdDate;
	private String createdBy;
	private Long editedBy;
	private Boolean riskcareBrand;
	private String otherInfo;
	private String email2;
	private Boolean defunct;
	private Long referringEmpId;
	private String marketingSource;
	private Long clientGroupID;
	private Long clientAddressID;

	public Contact() { }

	public Contact (ContactBuilder builder) {
		id = builder.id;
		organisationId = builder.organisationId;
		title = builder.title;
		firstName = builder.firstName;
		lastName = builder.lastName;
		position = builder.position;
		phone = builder.phone;
		email = builder.email;
		exEmployee = builder.exEmployee;
		phone2 = builder.phone2;
		phone3 = builder.phone3;
		lastChecked = builder.lastChecked;
		authorityID = builder.authorityID;
		productAreaID = builder.productAreaID;
		businessTypeID = builder.businessTypeID;
		autoEmail = builder.autoEmail;
		assistant = builder.assistant;
		assistantEmail = builder.assistantEmail;
		assistantPhone = builder.assistantPhone;
		contactFrequencyID = builder.contactFrequencyID;
		personalUserID = builder.personalUserID;
		sourceID = builder.sourceID;
		bossID = builder.bossID;
		createdDate = builder.createdDate;
		createdBy = builder.createdBy;
		editedBy = builder.editedBy;
		riskcareBrand = builder.riskcareBrand;
		otherInfo = builder.otherInfo;
		email2 = builder.email2;
		defunct = builder.defunct;
		referringEmpId = builder.referringEmpId;
		marketingSource = builder.marketingSource;
		clientGroupID = builder.clientGroupID;
		clientAddressID = builder.clientAddressID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isExEmployee() {
		return exEmployee;
	}

	public void setExEmployee(boolean exEmployee) {
		this.exEmployee = exEmployee;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public LocalDateTime getLastChecked() {
		return lastChecked;
	}

	public void setLastChecked(LocalDateTime lastChecked) {
		this.lastChecked = lastChecked;
	}

	public Long getAuthorityID() {
		return authorityID;
	}

	public void setAuthorityID(Long authorityID) {
		this.authorityID = authorityID;
	}

	public Long getProductAreaID() {
		return productAreaID;
	}

	public void setProductAreaID(Long productAreaID) {
		this.productAreaID = productAreaID;
	}

	public Long getBusinessTypeID() {
		return businessTypeID;
	}

	public void setBusinessTypeID(Long businessTypeID) {
		this.businessTypeID = businessTypeID;
	}

	public Boolean getAutoEmail() {
		return autoEmail;
	}

	public void setAutoEmail(Boolean autoEmail) {
		this.autoEmail = autoEmail;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public String getAssistantEmail() {
		return assistantEmail;
	}

	public void setAssistantEmail(String assistantEmail) {
		this.assistantEmail = assistantEmail;
	}

	public String getAssistantPhone() {
		return assistantPhone;
	}

	public void setAssistantPhone(String assistantPhone) {
		this.assistantPhone = assistantPhone;
	}

	public Long getContactFrequencyID() {
		return contactFrequencyID;
	}

	public void setContactFrequencyID(Long contactFrequencyID) {
		this.contactFrequencyID = contactFrequencyID;
	}

	public Long getPersonalUserID() {
		return personalUserID;
	}

	public void setPersonalUserID(Long personalUserID) {
		this.personalUserID = personalUserID;
	}

	public Long getSourceID() {
		return sourceID;
	}

	public void setSourceID(Long sourceID) {
		this.sourceID = sourceID;
	}

	public Long getBossID() {
		return bossID;
	}

	public void setBossID(Long bossID) {
		this.bossID = bossID;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(Long editedBy) {
		this.editedBy = editedBy;
	}

	public Boolean getRiskcareBrand() {
		return riskcareBrand;
	}

	public void setRiskcareBrand(Boolean riskcareBrand) {
		this.riskcareBrand = riskcareBrand;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public Boolean getDefunct() {
		return defunct;
	}

	public void setDefunct(Boolean defunct) {
		this.defunct = defunct;
	}

	public Long getReferringEmpId() {
		return referringEmpId;
	}

	public void setReferringEmpId(Long referringEmpId) {
		this.referringEmpId = referringEmpId;
	}

	public String getMarketingSource() {
		return marketingSource;
	}

	public void setMarketingSource(String marketingSource) {
		this.marketingSource = marketingSource;
	}

	public Long getClientGroupID() {
		return clientGroupID;
	}

	public void setClientGroupID(Long clientGroupID) {
		this.clientGroupID = clientGroupID;
	}

	public Long getClientAddressID() {
		return clientAddressID;
	}

	public void setClientAddressID(Long clientAddressID) {
		this.clientAddressID = clientAddressID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Contact contact = (Contact) o;
		return Objects.equals(id, contact.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public static class ContactBuilder {
		private Long id;
		private Long organisationId;
		private String title;
		private String firstName;
		private String lastName;
		private String position;
		private String phone;
		private String email;
		private Boolean exEmployee;
		private String phone2;
		private String phone3;
		private LocalDateTime lastChecked;
		private Long authorityID;
		private Long productAreaID;
		private Long businessTypeID;
		private Boolean autoEmail;
		private String assistant;
		private String assistantEmail;
		private String assistantPhone;
		private Long contactFrequencyID;
		private Long personalUserID;
		private Long sourceID;
		private Long bossID;
		private LocalDateTime createdDate;
		private String createdBy;
		private Long editedBy;
		private Boolean riskcareBrand;
		private String otherInfo;
		private String email2;
		private Boolean defunct;
		private Long referringEmpId;
		private String marketingSource;
		private Long clientGroupID;
		private Long clientAddressID;

		public ContactBuilder id (Long id) {
			this.id = id;
			return this;
		}

		public ContactBuilder organisationId (Long organisationId) {
			this.organisationId = organisationId;
			return this;
		}

		public ContactBuilder title (String title) {
			this.title = title;
			return this;
		}

		public ContactBuilder firstName (String firstName) {
			this.firstName = firstName;
			return this;
		}

		public ContactBuilder lastName (String lastName) {
			this.lastName = lastName;
			return this;
		}

		public ContactBuilder position (String position) {
			this.position = position;
			return this;
		}

		public ContactBuilder phone (String phone) {
			this.phone = phone;
			return this;
		}

		public ContactBuilder email (String email) {
			this.email = email;
			return this;
		}

		public ContactBuilder exEmployee (Boolean exEmployee) {
			this.exEmployee = exEmployee;
			return this;
		}

		public ContactBuilder phone2 (String phone2) {
			this.phone2 = phone2;
			return this;
		}

		public ContactBuilder phone3 (String phone3) {
			this.phone3 = phone3;
			return this;
		}

		public ContactBuilder lastChecked (LocalDateTime lastChecked) {
			this.lastChecked = lastChecked;
			return this;
		}

		public ContactBuilder authorityID (Long authorityID) {
			this.authorityID = authorityID;
			return this;
		}

		public ContactBuilder productAreaID (Long productAreaID) {
			this.productAreaID = productAreaID;
			return this;
		}

		public ContactBuilder businessTypeID (Long businessTypeID) {
			this.businessTypeID = businessTypeID;
			return this;
		}

		public ContactBuilder autoEmail (Boolean autoEmail) {
			this.autoEmail = autoEmail;
			return this;
		}

		public ContactBuilder assistant (String assistant) {
			this.assistant = assistant;
			return this;
		}

		public ContactBuilder assistantEmail (String assistantEmail) {
			this.assistantEmail = assistantEmail;
			return this;
		}

		public ContactBuilder assistantPhone (String assistantPhone) {
			this.assistantPhone = assistantPhone;
			return this;
		}

		public ContactBuilder contactFrequencyID (Long contactFrequencyID) {
			this.contactFrequencyID = contactFrequencyID;
			return this;
		}

		public ContactBuilder personalUserID (Long personalUserID) {
			this.personalUserID = personalUserID;
			return this;
		}

		public ContactBuilder sourceID (Long sourceID) {
			this.sourceID = sourceID;
			return this;
		}

		public ContactBuilder bossID (Long bossID) {
			this.bossID = bossID;
			return this;
		}

		public ContactBuilder createdDate (LocalDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}

		public ContactBuilder createdBy (String createdBy) {
			this.createdBy = createdBy;
			return this;
		}

		public ContactBuilder editedBy (Long editedBy) {
			this.editedBy = editedBy;
			return this;
		}

		public ContactBuilder riskcareBrand (Boolean riskcareBrand) {
			this.riskcareBrand = riskcareBrand;
			return this;
		}

		public ContactBuilder otherInfo (String otherInfo) {
			this.otherInfo = otherInfo;
			return this;
		}

		public ContactBuilder email2 (String email2) {
			this.email2 = email2;
			return this;
		}

		public ContactBuilder defunct (Boolean defunct) {
			this.defunct = defunct;
			return this;
		}

		public ContactBuilder referringEmpId (Long referringEmpId) {
			this.referringEmpId = referringEmpId;
			return this;
		}

		public ContactBuilder marketingSource (String marketingSource) {
			this.marketingSource = marketingSource;
			return this;
		}

		public ContactBuilder clientGroupID (Long clientGroupID) {
			this.clientGroupID = clientGroupID;
			return this;
		}

		public ContactBuilder clientAddressID (Long clientAddressID) {
			this.clientAddressID = clientAddressID;
			return this;
		}

		public Contact build() { return new Contact(this); }
	}
}
