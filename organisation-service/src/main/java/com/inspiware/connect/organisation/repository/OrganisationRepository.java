package com.inspiware.connect.organisation.repository;

import java.util.*;

import com.inspiware.connect.organisation.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class OrganisationRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Organisation add(Organisation organisation) {
		// TODO: Implement
		// organisation.setId((long) (organisations.size()+1));
		// organisations.add(organisation);
		return organisation;
	}

	/**
	 * Finds a client for a given identifier.
	 * @param id Unique client identifier
	 * @return <code>Organisation</code> object.
	 * @throws EmptyResultDataAccessException exception if record not found.
	 */
	public Organisation findById(Long id) {
		return this.jdbcTemplate.queryForObject (
				"SELECT \n" +
				"  Clients.ClientID,\n" +
				"  Name,\n" +
				"  ISNULL(Address1, ''),\n" +
				"  ISNULL(Address2, ''),\n" +
				"  ISNULL(City, ''),\n" +
				"  ISNULL(County, ''),\n" +
				"  ISNULL(PostCode, ''),\n" +
				"  ISNULL(Country, ''),\n" +
				"  ISNULL(Phone, ''),\n" +
				"  ISNULL(Website, ''),\n" +
				"  ISNULL(Prospective, 0),\n" +
				"  ISNULL(DirPath, ''),\n" +
				"  ISNULL(EmailTemplate, ''),\n" +
				"  ISNULL(ParentCompanyID, 0),\n" +
				"  ISNULL(HouseAccount,0),\n" +
				"  ISNULL(ClientTypeID,0),\n" +
				"  ISNULL(ClientGroupID,0),\n" +
				"  ISNULL(ClientAddressID,0)\n" +
				"FROM Clients\n" +
				"  WHERE ClientID = ?",
			new Object[] {id},
			(resultSet, i) -> new Organisation.OrganisationBuilder()
				.id(resultSet.getLong("ClientId"))
				.name(resultSet.getString("Name"))
				.address1(resultSet.getString(3))
				.address2(resultSet.getString(4))
				.city(resultSet.getString(5))
				.postcode(resultSet.getString(7))
				.country(resultSet.getString(8))
				.phone(resultSet.getString(9))
				.webSite(resultSet.getString(10))
				.prospective(resultSet.getInt(11) == 1)
				.dirPath(resultSet.getString(12))
				.emailTemplate(resultSet.getString(13))
				.parentCompanyId(resultSet.getLong(14))
				.houseAccount(resultSet.getInt(15) == 1)
				.clientTypeId(resultSet.getLong(16))
				.clientGroupId(resultSet.getLong(17))
				.clientAddressId(resultSet.getLong(17))
				.build());
	}

	/**
	 * Finds all clients for a given identifier.
	 * @return A collection of <code>Organisation</code> object.
	 */
	public List<Organisation> findAll() {
		return this.jdbcTemplate.query (
				"SELECT \n" +
				"  Clients.ClientID,\n" +
				"  Name,\n" +
				"  ISNULL(Address1, ''),\n" +
				"  ISNULL(Address2, ''),\n" +
				"  ISNULL(City, ''),\n" +
				"  ISNULL(County, ''),\n" +
				"  ISNULL(PostCode, ''),\n" +
				"  ISNULL(Country, ''),\n" +
				"  ISNULL(Phone, ''),\n" +
				"  ISNULL(Website, ''),\n" +
				"  ISNULL(Prospective, 0),\n" +
				"  ISNULL(DirPath, ''),\n" +
				"  ISNULL(EmailTemplate, ''),\n" +
				"  ISNULL(ParentCompanyID, 0),\n" +
				"  ISNULL(HouseAccount,0),\n" +
				"  ISNULL(ClientTypeID,0),\n" +
				"  ISNULL(ClientGroupID,0),\n" +
				"  ISNULL(ClientAddressID,0)\n" +
				"FROM Clients",
				(resultSet, i) -> new Organisation.OrganisationBuilder()
					.id(resultSet.getLong("ClientId"))
					.name(resultSet.getString("Name"))
					.address1(resultSet.getString(3))
					.address2(resultSet.getString(4))
					.city(resultSet.getString(5))
					.postcode(resultSet.getString(7))
					.country(resultSet.getString(8))
					.phone(resultSet.getString(9))
					.webSite(resultSet.getString(10))
					.prospective(resultSet.getInt(11) == 1)
					.dirPath(resultSet.getString(12))
					.emailTemplate(resultSet.getString(13))
					.parentCompanyId(resultSet.getLong(14))
					.houseAccount(resultSet.getInt(15) == 1)
					.clientTypeId(resultSet.getLong(16))
					.clientGroupId(resultSet.getLong(17))
					.clientAddressId(resultSet.getLong(17))
					.build());
	}
}
