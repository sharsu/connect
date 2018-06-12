package com.inspiware.connect.organisation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Organisation represents Rainmamker client instance.
 * <p>
 * @see OrganisationBuilder
 */
public final class Organisation implements Serializable {

	private final Long id;
	private final String name;
	private final String address1;
	private final String address2;
	private final String city;
	private final String postcode;
	private final String country;
	private final String phone;
	private final String webSite;
	private final Boolean prospective;
	private final String dirPath;
	private final String emailTemplate;
	private final Boolean houseAccount;
	private final Long parentCompanyId;
	private final Long clientTypeId;
	private final Long clientGroupId;
	private final Long clientAddressId;
	private final List<Contact> contacts;

	private Organisation( OrganisationBuilder builder ) {
		this.id = builder.id;
		this.name = builder.name;
		this.address1 = builder.address1;
		this.address2 = builder.address2;
		this.city = builder.city;
		this.postcode = builder.postcode;
		this.country = builder.country;
		this.phone = builder.phone;
		this.webSite = builder.webSite;
		this.prospective = builder.prospective;
		this.dirPath = builder.dirPath;
		this.emailTemplate = builder.emailTemplate;
		this.houseAccount = builder.houseAccount;
		this.parentCompanyId = builder.parentCompanyId;
		this.clientTypeId = builder.clientTypeId;
		this.clientGroupId = builder.clientGroupId;
		this.clientAddressId = builder.clientAddressId;
		this.contacts = builder.contacts;
	}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public String getWebSite() {
		return webSite;
	}

	public Boolean getProspective() {
		return prospective;
	}

	public String getDirPath() {
		return dirPath;
	}

	public String getEmailTemplate() {
		return emailTemplate;
	}

	public Boolean getHouseAccount() {
		return houseAccount;
	}

	public Long getParentCompanyId() {
		return parentCompanyId;
	}

	public Long getClientTypeId() {
		return clientTypeId;
	}

	public Long getClientGroupId() {
		return clientGroupId;
	}

	public Long getClientAddressId() {
		return clientAddressId;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Organisation that = (Organisation) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Organisation{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address1='" + address1 + '\'' +
				", address2='" + address2 + '\'' +
				", city='" + city + '\'' +
				", postcode='" + postcode + '\'' +
				", country='" + country + '\'' +
				", phone='" + phone + '\'' +
				", webSite='" + webSite + '\'' +
				", prospective=" + prospective +
				", dirPath='" + dirPath + '\'' +
				", emailTemplate='" + emailTemplate + '\'' +
				", houseAccount=" + houseAccount +
				", parentCompanyId=" + parentCompanyId +
				", clientTypeId=" + clientTypeId +
				", clientGroupId=" + clientGroupId +
				", clientAddressId=" + clientAddressId +
				'}';
	}

	/**
	 * Constructs an organisation object
	 * <p>
	 * @see Organisation
	 */
	public static class OrganisationBuilder {
		private Long id;
		private String name;
		private String address1;
		private String address2;
		private String city;
		private String postcode;
		private String country;
		private String phone;
		private String webSite;
		private Boolean prospective;
		private String dirPath;
		private String emailTemplate;
		private Boolean houseAccount;
		private Long parentCompanyId;
		private Long clientTypeId;
		private Long clientGroupId;
		private Long clientAddressId;
		private List<Contact> contacts = new ArrayList<>();

		public OrganisationBuilder id (Long id) {
			this.id = id;
			return this;
		}
		public OrganisationBuilder name (String name) {
			this.name = name;
			return this;
		}
		public OrganisationBuilder address1 (String address1) {
			this.address1 = address1;
			return this;
		}
		public OrganisationBuilder address2 (String address2) {
			this.address2 = address2;
			return this;
		}
		public OrganisationBuilder city (String city) {
			this.city = city;
			return this;
		}
		public OrganisationBuilder postcode (String postcode) {
			this.postcode = postcode;
			return this;
		}
		public OrganisationBuilder country (String country) {
			this.country = country;
			return this;
		}
		public OrganisationBuilder phone (String phone) {
			this.phone = phone;
			return this;
		}
		public OrganisationBuilder webSite (String webSite) {
			this.webSite = webSite;
			return this;
		}
		public OrganisationBuilder prospective (Boolean prospective) {
			this.prospective = prospective;
			return this;
		}
		public OrganisationBuilder dirPath (String dirPath) {
			this.dirPath = dirPath;
			return this;
		}
		public OrganisationBuilder emailTemplate (String emailTemplate) {
			this.emailTemplate = emailTemplate;
			return this;
		}
		public OrganisationBuilder houseAccount (Boolean houseAccount) {
			this.houseAccount = houseAccount;
			return this;
		}
		public OrganisationBuilder parentCompanyId (Long parentCompanyId) {
			this.parentCompanyId = parentCompanyId;
			return this;
		}
		public OrganisationBuilder clientTypeId (Long clientTypeId) {
			this.clientTypeId = clientTypeId;
			return this;
		}
		public OrganisationBuilder clientGroupId (Long clientGroupId) {
			this.clientGroupId = clientGroupId;
			return this;
		}
		public OrganisationBuilder clientAddressId (Long clientAddressId) {
			this.clientAddressId = clientAddressId;
			return this;
		}
		public OrganisationBuilder contacts (List contacts) {
			this.contacts = contacts;
			return this;
		}
		public Organisation build() {
			return new Organisation(this);
		}
	}

}
